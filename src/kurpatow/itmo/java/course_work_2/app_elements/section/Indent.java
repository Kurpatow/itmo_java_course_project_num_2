package kurpatow.itmo.java.course_work_2.app_elements.section;

public class Indent {
    private String heading;
    private String text;
    private String firstText;
    private String secondText;
    Indent firstReply;
    Indent secondReply;

    public Indent(String heading, String text) {
        setHeading(heading);
        setText(text);
    }

    protected Indent(String heading, String text, String firstReply, String secondReply) {
        setHeading(heading);
        setText(text);
        setFirstText(firstReply);
        setSecondText(secondReply);
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

    public String getFirstText() {return firstText;}
    public void setFirstText(String firstText) {this.firstText = firstText;}

    public String getSecondText() {return secondText;}
    public void setSecondText(String secondText) {this.secondText = secondText;}

    public Indent getFirstReply() {return firstReply;}
    public void setFirstReply(Indent firstReply) {this.firstReply = firstReply;}

    public Indent getSecondReply() {return secondReply;}
    public void setSecondReply(Indent secondReply) {this.secondReply = secondReply;}

    public boolean isLastIndent() {
        return getFirstReply() == null;
    }
}
