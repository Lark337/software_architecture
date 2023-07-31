package d2.Command;

import d2.Command.TextFileOperation.Operations.OpenTextFileOperation;
import d2.Command.TextFileOperation.Operations.SaveTextFileOperation;
import d2.Command.TextFileOperationExecutor;

public class Main {
    public static void main(String[] args) {  
    TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
    textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
    textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt")));
    }
}
