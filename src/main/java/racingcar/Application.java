package racingcar;

import racingcar.controller.Orchestrator;
import racingcar.model.InputValidator;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator(
                new ConsoleView(),
                new InputValidator()
        );
        orchestrator.playRacingGame();
    }
}
