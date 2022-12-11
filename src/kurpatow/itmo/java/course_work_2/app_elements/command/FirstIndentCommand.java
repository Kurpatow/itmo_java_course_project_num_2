package kurpatow.itmo.java.course_work_2.app_elements.command;

import kurpatow.itmo.java.course_work_2.app_elements.Game;

public class FirstIndentCommand extends BaseCommand {
    public FirstIndentCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.nextStep(game.getCurrentIndent().getFirstReply());
    }
}
