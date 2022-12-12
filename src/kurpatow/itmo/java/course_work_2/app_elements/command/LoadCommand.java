package kurpatow.itmo.java.course_work_2.app_elements.command;

import kurpatow.itmo.java.course_work_2.app_elements.Game;

public class LoadCommand extends BaseCommand {
    public LoadCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {

        game.loadGame();
    }
}
