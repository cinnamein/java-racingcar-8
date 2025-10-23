package racingcar.controller;

import java.util.List;
import racingcar.model.InputValidator;
import racingcar.model.StringParser;
import racingcar.view.ConsoleView;

public class Orchestrator {

    private final ConsoleView consoleView;
    private final InputValidator inputValidator;
    private final StringParser stringParser;

    public Orchestrator(
            ConsoleView consoleView,
            InputValidator inputValidator,
            StringParser stringParser
    ) {
        this.consoleView = consoleView;
        this.inputValidator = inputValidator;
        this.stringParser = stringParser;
    }

    public void playRacingGame() {
        String carNamesInput = consoleView.getCarNamesInput();
        inputValidator.validateInputString(carNamesInput);
        List<String> carNames = stringParser.parseCarNames(carNamesInput);
        int attemptsCount = consoleView.getAttemptsCountInput();
        inputValidator.validateAttemptsCount(attemptsCount);
    }
}
