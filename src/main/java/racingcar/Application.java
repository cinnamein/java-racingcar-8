package racingcar;

import racingcar.controller.Orchestrator;
import racingcar.model.domain.CarFactory;
import racingcar.model.domain.DetermineResult;
import racingcar.model.util.InputValidator;
import racingcar.model.domain.MovementCalculator;
import racingcar.model.util.StringParser;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator(
                new ConsoleView(),
                new InputValidator(),
                new StringParser(),
                new CarFactory(),
                new MovementCalculator(),
                new DetermineResult()
        );
        orchestrator.playRacingGame();
    }
}
