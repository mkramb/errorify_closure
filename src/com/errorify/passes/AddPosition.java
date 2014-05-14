package com.errorify.passes;

import com.google.javascript.jscomp.AbstractCompiler;
import com.google.javascript.jscomp.CompilerPass;
import com.google.javascript.jscomp.NodeTraversal;
import com.google.javascript.rhino.IR;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;

public class AddPosition implements CompilerPass, NodeTraversal.Callback {
	final AbstractCompiler compiler;

	public AddPosition(AbstractCompiler compiler) {
		this.compiler = compiler;
	}

	@Override
	public void process(Node externs, Node root) {
		NodeTraversal.traverseRoots(this.compiler, this, externs, root);
	}

	@Override
	public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent) {
		return true;
	}

	@Override
	public void visit(NodeTraversal t, Node n, Node parent) {
		switch (n.getType()) {
			case Token.CALL:
				Node target = n.getFirstChild();

				if ("errorify.log".equals(target.getQualifiedName())) {
					Node funcArg = target.getNext();

					if (funcArg.getParent().getChildCount() == 3) {
						funcArg.getParent().addChildToBack(
							IR.arraylit(
								IR.number((target.getLineno() > 0) ? target.getLineno() : 1),
								IR.number((target.getCharno() > 0) ? target.getCharno() : 1)
							)
						);
	
						this.compiler.reportCodeChange();
					}
				}

			break;
		}
	}
}
