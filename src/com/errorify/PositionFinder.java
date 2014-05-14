package com.errorify;

import com.errorify.server.gen.ClosureException;
import com.google.debugging.sourcemap.SourceMapConsumerV3;
import com.google.debugging.sourcemap.SourceMapParseException;
import com.google.debugging.sourcemap.proto.Mapping.OriginalMapping;

public class PositionFinder {
	protected SourceMapConsumerV3 consumer;
	
	public Boolean parse(String input) throws ClosureException {
		try {
			this.consumer = new SourceMapConsumerV3();
			this.consumer.parse(input);
		} catch (SourceMapParseException e) {
			throw new ClosureException(e.getMessage());
		}

		return true;
	}

	public int[] translate(int line, int column) {
		OriginalMapping mappging = this.consumer.getMappingForLine(line, column);
		int[] position = new int[2];

		position[0] = mappging.getLineNumber();
		position[1] = mappging.getColumnPosition();

		return position;
	}
}
