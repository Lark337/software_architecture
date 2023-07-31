package d2.Command.TextFileOperation.Operations;

import d2.Command.TextFile;
import d2.Command.TextFileOperation.TextFileOperation;

public class SaveTextFileOperation implements TextFileOperation {

    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile){
        this.textFile = textFile;
    }
    
    @Override
    public String execute() {
        return textFile.save();
    }
}
