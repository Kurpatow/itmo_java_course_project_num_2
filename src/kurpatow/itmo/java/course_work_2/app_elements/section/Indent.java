package kurpatow.itmo.java.course_work_2.app_elements.section;

public class Indent {
    private String heading;
    private String text;
    private String firstTextBox;
    private String secondTextBox;
    Indent firstReply;
    Indent secondReply;

    public Indent(String heading, String text) {
        setHeading(heading);
        setText(text);
    }
    protected Indent(String heading, String text, String firstTextBox, String secondTextBox) {
        setHeading(heading);
        setText(text);
        setFirstTextBox(firstTextBox);
        setSecondTextBox(secondTextBox);
    }

    public String getHeading() {return heading;}

    public void setHeading(String heading) {
        if (heading == null) throw new IllegalArgumentException("Поле Heading не должно быть пустым");
        this.heading = heading;
    }

    public void printText() {
        System.out.println(text);
    }
    public void setText(String text) {
        if (text == null) throw new IllegalArgumentException("Поле Text не должно быть пустым");
        this.text = text;
    }

    public String getFirstTextBox() {return firstTextBox;}
    public void setFirstTextBox(String firstTextBox) {this.firstTextBox = firstTextBox;}

    public String getSecondTextBox() {return secondTextBox;}
    public void setSecondTextBox(String secondTextBox) {this.secondTextBox = secondTextBox;}

    public Indent getFirstReply() {return firstReply;}
    public void setFirstReply(Indent firstReply) {this.firstReply = firstReply;}

    public Indent getSecondReply() {return secondReply;}
    public void setSecondReply(Indent secondReply) {this.secondReply = secondReply;}

    public boolean isLastIndent() {
        return getFirstReply() == null;
    }
}
