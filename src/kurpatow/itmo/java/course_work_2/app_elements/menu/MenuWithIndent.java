package kurpatow.itmo.java.course_work_2.app_elements.menu;

import kurpatow.itmo.java.course_work_2.app_elements.command.MenuCommand;
import kurpatow.itmo.java.course_work_2.app_elements.section.Indent;

public class MenuWithIndent extends BaseMenu {
    MenuCommand firstReply;
    MenuCommand secondReply;
    MenuCommand returnToMainMenu;
    private Indent indent;

    public MenuWithIndent(Indent indent, MenuCommand firstReply, MenuCommand secondReply, MenuCommand returnToMainMenu) {
        setIndent(indent);
        setFirstReply(firstReply);
        setSecondReply(secondReply);
        setReturnToMainMenu(returnToMainMenu);
        setText();
    }

    public void setFirstReply(MenuCommand firstReply) {
        if (firstReply == null)
            throw new IllegalArgumentException("Значение команды firstReply в меню равен null");
        this.firstReply = firstReply;
    }

    public void setSecondReply(MenuCommand secondReply) {
        if (secondReply == null)
            throw new IllegalArgumentException("Значение команды secondReply в меню равен null");
        this.secondReply = secondReply;
    }

    public void setReturnToMainMenu(MenuCommand returnToMainMenu) {
        if (returnToMainMenu == null)
            throw new IllegalArgumentException("Значение команды returnToMainMenu в меню равен null");
        this.returnToMainMenu = returnToMainMenu;
    }

    public void setIndent(Indent indent) {
        if (indent == null)
            throw new IllegalArgumentException("Значение команды indent в меню равен null");
        this.indent = indent;
    }

    private void setText() {
        text = "1. " + indent.getFirstText() + "\n" +
                "2. " + indent.getSecondText() + "\n" +
                "3. Выйти в главное меню";
    }

    @Override
    public void getUserReply() {
        int userCommandNumber = getUserCommandNumber();

        switch (userCommandNumber) {
            case 1: firstReply.execute();
            break;
            case 2: secondReply.execute();
            break;
            case 3: returnToMainMenu.execute();
            break;
            default: System.out.println("Ошибка! Данной команды не существует. Попробуйте еще раз.");
            break;
        }
    }
}
