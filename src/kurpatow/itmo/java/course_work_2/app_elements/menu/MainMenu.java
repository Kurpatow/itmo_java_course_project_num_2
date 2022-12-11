package kurpatow.itmo.java.course_work_2.app_elements.menu;

import kurpatow.itmo.java.course_work_2.app_elements.command.MenuCommand;

public class MainMenu extends BaseMenu {
    private MenuCommand startNewGame;
    private MenuCommand continueGame;
    private MenuCommand loadGame;
    private MenuCommand saveGame;
    private MenuCommand exit;

    public MainMenu (MenuCommand startNewGame,
                     MenuCommand continueGame,
                     MenuCommand loadGame,
                     MenuCommand saveGame,
                     MenuCommand exit)
    {
        setText(StaticMenuInfo.MAIN_MENU_TEXT);
        setStartNewGame(startNewGame);
        setContinueGame(continueGame);
        setLoadGame(loadGame);
        setSaveGame(saveGame);
        setExit(exit);
    }

    public void setStartNewGame(MenuCommand startNewGame) {
        if (startNewGame == null)
            throw new IllegalArgumentException("Значение команды startNewGame в MainMenu равна null");
        this.startNewGame = startNewGame;
    }

    public void setContinueGame(MenuCommand continueGame) {
        if (continueGame == null)
            throw new IllegalArgumentException("Значение команды continueGame в MainMenu равна null");
        this.continueGame = continueGame;
    }

    public void setLoadGame(MenuCommand loadGame) {
        if (loadGame == null)
            throw new IllegalArgumentException("Значение команды loadGame в MainMenu равна null");
        this.loadGame = loadGame;
    }

    public void setSaveGame(MenuCommand saveGame) {
        if (saveGame == null)
            throw new IllegalArgumentException("Значение команды saveGame в MainMenu равна null");
        this.saveGame = saveGame;
    }

    public void setExit(MenuCommand exit) {
        if (exit == null)
            throw new IllegalArgumentException("Значение команды exit в MainMenu равна null");
        this.exit = exit;
    }

    @Override
    public void getUserReply() {
        int userCommandNumber = getUserCommandNumber();

        switch (userCommandNumber) {
            case 1: startNewGame.execute();
            break;
            case 2: continueGame.execute();
            break;
            case 3: loadGame.execute();
            break;
            case 4: saveGame.execute();
            break;
            case 5: exit.execute();
            break;
            default: System.out.println("Ошибка! Данной команды не существует. Попробуйте еще раз.");
            break;
        }
    }
}
