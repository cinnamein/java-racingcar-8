package racingcar;

import racingcar.controller.Orchestrator;
import racingcar.model.CarFactory;
import racingcar.model.InputValidator;
import racingcar.model.MovementCalculator;
import racingcar.model.StringParser;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator(
                new ConsoleView(),
                new InputValidator(),
                new StringParser(),
                new CarFactory(),
                new MovementCalculator()
        );
        orchestrator.playRacingGame();
    }
}
