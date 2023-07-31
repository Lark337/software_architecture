package d2.Command.TextFileOperation.Operations;

import d2.Command.TextFile;
import d2.Command.TextFileOperation.TextFileOperation;

public class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;
    
    public OpenTextFileOperation(TextFile textFile){
        this.textFile = textFile;
    }
    
    @Override
    public String execute() {
        return textFile.open();
    }
}
