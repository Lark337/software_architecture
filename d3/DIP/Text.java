package d3.DIP;

public class Text {
    String text;
    Printer myPrinter;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void print(){
        myPrinter.print(text);
    }

}
