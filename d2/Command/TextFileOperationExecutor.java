package d2.Command;

import java.util.ArrayList;
import java.util.List;

import d2.Command.TextFileOperation.TextFileOperation;

public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();
    
    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
