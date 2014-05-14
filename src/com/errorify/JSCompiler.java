package com.errorify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.errorify.passes.AddPosition;
import com.errorify.passes.AddResourceId;
import com.errorify.passes.AddTryCatch;
import com.errorify.server.gen.ClosureException;
import com.google.common.collect.ArrayListMultimap;
import com.google.javascript.jscomp.CheckLevel;
import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CustomPassExecutionTime;
import com.google.javascript.jscomp.DiagnosticGroups;
import com.google.javascript.jscomp.JSError;
import com.google.javascript.jscomp.JSSourceFile;
import com.google.javascript.jscomp.PropertyRenamingPolicy;
import com.google.javascript.jscomp.Result;
import com.google.javascript.jscomp.SourceMap;
import com.google.javascript.jscomp.VariableRenamingPolicy;

public class JSCompiler {
	protected String sourceMap = "";
	protected String sourceDot = "";
	protected String resourceId = "";

	protected String sourceProcessed = "";
	protected Compiler compiler;

	protected List<String> compilerConfig = new ArrayList<String>();
	protected List<String> compilerErrors = new ArrayList<String>();
	protected List<String> compilerWarnings = new ArrayList<String>();

	public JSCompiler(List<String> config) {
		this.compilerConfig = config;
	}

	public void compile(String resourceId, String code) throws ClosureException {
		this.compiler = new Compiler();
		this.resourceId = resourceId;

		try {
			JSSourceFile extern = JSSourceFile.fromCode("extern.js", "errorify={};");
			JSSourceFile input = JSSourceFile.fromCode("input.js", code);
			Result compilerResult = this.compiler.compile(extern, input, getCompilerOptions());

			for(JSError error : compilerResult.errors) {
				this.compilerErrors.add(error.toString());
			}

			for(JSError warning : compilerResult.warnings) {
				this.compilerWarnings.add(warning.toString());
			}

			if (this.compilerErrors.isEmpty()) {
				StringBuilder temp = new StringBuilder();
				this.sourceProcessed = compiler.toSource();

				compilerResult.sourceMap.validate(true);
				compilerResult.sourceMap.appendTo(temp, "sourcemap.js");

				this.sourceMap = temp.toString();
			}
		} catch (IOException e) {
			throw new ClosureException(e.getMessage());
		}
	}

	public String getSourceMap() {
		return this.sourceMap;
	}

	public String getSourceProcessed() {
		return this.sourceProcessed;
	}

	public List<String> getCompilereErrors() {
		return this.compilerErrors;
	}

	public List<String> getCompilereWarnings() {
		return this.compilerWarnings;
	}

	protected CompilerOptions getCompilerOptions() {
		CompilerOptions options = new CompilerOptions();
		CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(options);

		options.sourceMapOutputPath = "testcode_source_map.out";
		options.sourceMapFormat = SourceMap.Format.V3;
		options.sourceMapDetailLevel = SourceMap.DetailLevel.ALL;

		options.setWarningLevel(DiagnosticGroups.EXTERNS_VALIDATION, CheckLevel.OFF);
		options.setWarningLevel(DiagnosticGroups.UNDEFINED_VARIABLES, CheckLevel.OFF);
		options.setWarningLevel(DiagnosticGroups.UNDEFINED_NAMES, CheckLevel.OFF);
		
		if (options.customPasses == null) {
			options.customPasses = ArrayListMultimap.create();
		}

		if (this.compilerConfig.contains("PrettyPrint")) {
			options.variableRenaming = VariableRenamingPolicy.OFF;
			options.propertyRenaming = PropertyRenamingPolicy.OFF;
			options.prettyPrint = true;
		}

		if (this.compilerConfig.contains("AddTryCatch")) {
			options.customPasses.put(
				CustomPassExecutionTime.BEFORE_OPTIMIZATION_LOOP,
				new AddTryCatch(compiler)
			);
		}

		options.customPasses.put(
			CustomPassExecutionTime.BEFORE_OPTIMIZATION_LOOP,
			new AddResourceId(compiler, resourceId)
		);

		options.customPasses.put(
			CustomPassExecutionTime.BEFORE_OPTIMIZATION_LOOP,
			new AddPosition(compiler)
		);

		return options;
	}
}
