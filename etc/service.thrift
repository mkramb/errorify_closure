/*
 * THRIFT (java & python)
 *
 * thrift -out ../src -r -gen java service.thrift
 * thrift -out ../../errorify/modules/website/apps/thrift -r -gen py:new_style service.thrift 
 */

namespace java com.errorify.server.gen

struct CompilerResult {
    1: string sourceProcessed;
    2: string sourceMap;
    4: list<string> compilerErrors;
    5: list<string> compilerWarnings;
}

struct SourcePosition {
    1:i32 line, 
    2:i32 column
}

exception ClosureException {
  1:string message
}

service ClosureService {

    CompilerResult compileJS(
        1:string resourceId,
        2:string code,
        3:list<string> config
    ) throws (
        1:ClosureException e
    )

    SourcePosition getSourcePosition(
        1:string sourceMap,
        2:i32 line,
        3:i32 column
    ) throws (
        1:ClosureException e
    )

}
