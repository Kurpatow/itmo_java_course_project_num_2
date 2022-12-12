package kurpatow.itmo.java.course_work_2.app_elements.command;

import kurpatow.itmo.java.course_work_2.app_elements.Game;

public abstract class BaseCommand implements MenuCommand {
    Game game;

    protected BaseCommand(Game game) {
        setGame(game);
    }

    private void setGame(Game game) {
        if (game == null) throw new IllegalArgumentException(
                "В конструктор BaseCommand передан объект Game со значением null.");
        this.game = game;
    }
}
