package com.errorify.server;

import java.util.List;
import org.apache.thrift.TException;

import com.errorify.server.gen.ClosureException;
import com.errorify.server.gen.ClosureService;
import com.errorify.server.gen.CompilerResult;
import com.errorify.server.gen.SourcePosition;
import com.errorify.JSCompiler;
import com.errorify.PositionFinder;

class ClosureServiceImpl implements ClosureService.Iface {
	@Override
	public SourcePosition getSourcePosition(String sourceMap, int line, int column)
		throws TException, ClosureException
	{
		SourcePosition sourcePosition = new SourcePosition();
		PositionFinder finder = new PositionFinder();
		finder.parse(sourceMap);

		int[] position = finder.translate(line, column);
		sourcePosition.setLine(position[0]);
		sourcePosition.setColumn(position[1]);

		return sourcePosition;
	}

	@Override
	public CompilerResult compileJS(String resourceId, String code, List<String> passes)
		throws TException, ClosureException
	{
		JSCompiler compiler = new JSCompiler(passes);
		CompilerResult result = new CompilerResult();
		compiler.compile(resourceId, code);

		result.setSourceProcessed(compiler.getSourceProcessed());
		result.setSourceMap(compiler.getSourceMap());

		result.setCompilerErrors(compiler.getCompilereErrors());
		result.setCompilerWarnings(compiler.getCompilereWarnings());

		return result;
	}
}
