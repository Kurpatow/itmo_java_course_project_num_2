package kurpatow.itmo.java.course_work_2.app_elements.menu;

import kurpatow.itmo.java.course_work_2.app_elements.command.MenuCommand;

public class StartMenu extends BaseMenu {
    MenuCommand startNewGame;
    MenuCommand loadGameFromFile;
    MenuCommand exit;

    public StartMenu(MenuCommand startNewGame, MenuCommand loadGameFromFile, MenuCommand exit) {
        setText(StaticMenuInfo.START_MENU_TEXT);
        setStartNewGame(startNewGame);
        setLoadGameFromFile(loadGameFromFile);
        setExit(exit);
    }

    public void setStartNewGame(MenuCommand startNewGame) {
        if (startNewGame == null)
            throw new IllegalArgumentException("Значение команды startGame в StartMenu равен null");
        this.startNewGame = startNewGame;
    }

    public void setLoadGameFromFile(MenuCommand loadGameFromFile) {
        if (loadGameFromFile == null)
            throw new IllegalArgumentException("Значение команды loadGameFromFile в StartMenu равен null");
        this.loadGameFromFile = loadGameFromFile;
    }

    public void setExit(MenuCommand exit) {
        if (exit == null)
            throw new IllegalArgumentException("Значение команды exit в StartMenu равен null");
        this.exit = exit;
    }

    @Override
    protected void getUserReply() {

        int userCommandNumber = getUserCommandNumber();

        switch (userCommandNumber) {
            case 1: startNewGame.execute();
            break;
            case 2: loadGameFromFile.execute();
            break;
            case 3: exit.execute();
            break;
            default: System.out.println("Ошибка! Данной команды не существует. Попробуйте еще раз.");
            break;
        }
    }
}
