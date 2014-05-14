package com.errorify.passes;

import java.lang.reflect.Method;

import com.google.common.base.Preconditions;
import com.google.javascript.jscomp.AbstractCompiler;
import com.google.javascript.jscomp.CompilerPass;
import com.google.javascript.jscomp.DiagnosticType;
import com.google.javascript.jscomp.JSError;
import com.google.javascript.jscomp.NodeTraversal;
import com.google.javascript.jscomp.NodeUtil;
import com.google.javascript.rhino.IR;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

public class AddTryCatch implements CompilerPass, NodeTraversal.Callback {
	final AbstractCompiler compiler;
	final DiagnosticType TRY_CATCH_ERROR = DiagnosticType.error("JSC_TRY_CATCH", "Error adding try/catch at root: {0}");

	public AddTryCatch(AbstractCompiler compiler) {
		this.compiler = compiler;
	}

	@Override
	public void process(Node externs, Node root) {
		Node top = root.getFirstChild();
		Node[] blocks = new Node[top.getChildCount()];

		for (int i=0; i<top.getChildCount(); i++) {
			blocks[i] = top.getChildAtIndex(i).cloneTree();
		}

		try {
			Class<?> c = Class.forName("com.google.javascript.rhino.IR");
			Method method = c.getMethod ("block", Node[].class);

			Node block = (Node) method.invoke(c, (Object)blocks);
			Node tryCatch = newTryCatch(
				IR.block(block), 
				IR.catchNode(
					IR.name("e"),
					IR.block(
						IR.exprResult(IR.call(
							jsCode("errorify.log"), 
							IR.name("e")
						))
					)
				)
			);

			root.getFirstChild().removeChildren();
			root.getFirstChild().addChildrenToBack(tryCatch);

			NodeTraversal.traverseRoots(this.compiler, this, externs, root);
		} catch (Exception e) {
			this.compiler.report(
				JSError.make(TRY_CATCH_ERROR, e.getMessage())
			);
		}
	}

	@Override
	public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent) {
		return true;
	}

	@Override
	public void visit(NodeTraversal t, Node n, Node parent) {
		switch (n.getType()) {
			case Token.FUNCTION:
				Node funcBlock = n.getFirstChild().getNext().getNext();
				Node tryCatch = newTryCatch(
					funcBlock.cloneTree(), 
					IR.catchNode(
						IR.name("e"),
						IR.block(
							IR.exprResult(IR.call(
								jsCode("errorify.log"), 
								IR.name("e")
							))
						)
					)
				);
	
				funcBlock.removeChildren();
				funcBlock.addChildrenToBack(tryCatch);
	
				this.compiler.reportCodeChange();
		}
	}

	protected Node jsCode(String prop) {
		return NodeUtil.newQualifiedNameNode(this.compiler.getCodingConvention(), prop);
	}

	protected Node newTryCatch(Node tryBody, Node catchNode) {
		Preconditions.checkState(tryBody.isBlock());
		Preconditions.checkState(catchNode.isCatch());

		Node block = new Node(Token.BLOCK, catchNode);
		Node catchBody = block.copyInformationFromForTree(tryBody);

		return new Node(Token.TRY, tryBody, catchBody);
	}
}
