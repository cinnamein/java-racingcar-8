package racingcar.controller;

import racingcar.model.InputValidator;
import racingcar.view.ConsoleView;

public class Orchestrator {

    private final ConsoleView consoleView;
    private final InputValidator inputValidator;

    public Orchestrator(
            ConsoleView consoleView,
            InputValidator inputValidator
    ) {
        this.consoleView = consoleView;
        this.inputValidator = inputValidator;
    }

    public void playRacingGame() {
        String carNamesInput = consoleView.getCarNamesInput();
        inputValidator.validateInputString(carNamesInput);
    }
}
