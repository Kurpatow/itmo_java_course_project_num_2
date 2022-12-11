package kurpatow.itmo.java.course_work_2.app_elements.command;

import kurpatow.itmo.java.course_work_2.app_elements.Game;

public class ExitCommand extends BaseCommand {
    public ExitCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.exit();
    }
}
