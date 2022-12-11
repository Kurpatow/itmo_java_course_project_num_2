package kurpatow.itmo.java.course_work_2.app_elements.menu;

import java.util.Scanner;

public abstract class BaseMenu {
    String text;
    String userText;

    protected void setText(String text) {
        if (text == null) throw new IllegalArgumentException("Ошибка! Текст отсутствует!");
        this.text = text;
    }

    private void printText() {
        System.out.println();
        System.out.println(this.text);
    }

    protected int getUserCommandNumber() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер команды:");
            userText = userInput.nextLine();
            if (isUserTextCorrect(userText)) {
                break;
            }
            System.out.println("Ошибка! Неверная команда.");
        }
        return Integer.parseInt(userText);
    }

    private boolean isUserTextCorrect(String userText) {
        try {
            Integer.parseInt(userText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    abstract void getUserReply();
    public void showAndRun() {
        printText();
        getUserReply();
    }
}
