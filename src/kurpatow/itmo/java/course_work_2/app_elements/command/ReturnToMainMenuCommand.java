package kurpatow.itmo.java.course_work_2.app_elements.command;

import kurpatow.itmo.java.course_work_2.app_elements.Game;

public class ReturnToMainMenuCommand extends BaseCommand {
    public ReturnToMainMenuCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.showMainMenu();
    }
}
