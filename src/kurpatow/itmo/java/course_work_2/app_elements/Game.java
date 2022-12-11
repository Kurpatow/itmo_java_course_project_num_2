package kurpatow.itmo.java.course_work_2.app_elements;

import kurpatow.itmo.java.course_work_2.app_elements.command.*;
import kurpatow.itmo.java.course_work_2.app_elements.io.IOOperations;
import kurpatow.itmo.java.course_work_2.app_elements.menu.MenuWithIndent;
import kurpatow.itmo.java.course_work_2.app_elements.menu.StartMenu;
import kurpatow.itmo.java.course_work_2.app_elements.menu.MainMenu;
import kurpatow.itmo.java.course_work_2.app_elements.section.Indent;
import kurpatow.itmo.java.course_work_2.app_elements.section.IndentInfo;
import kurpatow.itmo.java.course_work_2.app_elements.section.IndentUtils;

import java.io.FileNotFoundException;

public class Game {
    private Indent currentIndent;
    private final IOOperations<String> gameProgressHandler;

    public Game() {
        gameProgressHandler = new IOOperations<>();
    }

    private void setCurrentIndent(Indent indent) {
        currentIndent = indent;
    }

    public Indent getCurrentIndent() {
        return currentIndent;
    }

    public void startNewGame() {
        Indent startIndent = IndentUtils.getIndentHeading(IndentInfo.FOX_HEADING);
        nextStep(startIndent);
    }

    public void nextStep(Indent indent) {
        setCurrentIndent(indent);
        currentIndent.printText();

        if (currentIndent.isLastIndent()) {
            new StartMenu(
                    new StartNewGameCommand(this),
                    new LoadCommand(this),
                    new ExitCommand(this)).showAndRun();
            return;
        }
        new MenuWithIndent(
                indent,
                new FirstIndentCommand(this),
                new SecondIndentCommand(this),
                new ReturnToMainMenuCommand(this)).showAndRun();
    }

    public void showMainMenu() {
        new MainMenu(
                new StartNewGameCommand(this),
                new ContinueCommand(this),
                new LoadCommand(this),
                new SaveCommand(this),
                new ExitCommand(this)).showAndRun();
    }

    public void loadGame() {
        try {
            String loadIndentHeading = gameProgressHandler.readFromFile();
            System.out.println("Игра загружена.");
            nextStep(IndentUtils.getIndentHeading(loadIndentHeading));
        } catch (FileNotFoundException e) {
            System.out.println("Сохранения отсутствуют");
            if (currentIndent == null) {
                run();
            } else {
                showMainMenu();
            }
        }
    }

    public void saveGame() {
        System.out.println("Сохранение прогресса в файл...");
        gameProgressHandler.writeToFile(currentIndent.getHeading());
        System.out.println("Прогресс сохранён!");
        showMainMenu();
    }

    public void  continueGame() {nextStep(currentIndent);}

    public void exit() {System.out.println("Удачи! Спасибо, что поиграли:)");}

    public void run() {
        new StartMenu(
                new StartNewGameCommand(this),
                new LoadCommand(this),
                new ExitCommand(this)).showAndRun();
    }
}
