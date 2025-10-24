package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.DetermineResult;
import racingcar.model.InputValidator;
import racingcar.model.MovementCalculator;
import racingcar.model.StringParser;
import racingcar.view.ConsoleView;

public class Orchestrator {

    private final ConsoleView consoleView;
    private final InputValidator inputValidator;
    private final StringParser stringParser;
    private final CarFactory carFactory;
    private final MovementCalculator movementCalculator;
    private final DetermineResult determineResult;

    public Orchestrator(
            ConsoleView consoleView,
            InputValidator inputValidator,
            StringParser stringParser,
            CarFactory carFactory,
            MovementCalculator movementCalculator,
            DetermineResult determineResult
    ) {
        this.consoleView = consoleView;
        this.inputValidator = inputValidator;
        this.stringParser = stringParser;
        this.carFactory = carFactory;
        this.movementCalculator = movementCalculator;
        this.determineResult = determineResult;
    }

    public void playRacingGame() {
        String carNamesInput = consoleView.getCarNamesInput();
        inputValidator.validateInputString(carNamesInput);
        List<String> carNames = stringParser.parseCarNames(carNamesInput);
        List<Car> cars = carFactory.setupCars(carNames);

        int attemptsCount = consoleView.getAttemptsCountInput();
        inputValidator.validateAttemptsCount(attemptsCount);
        for (int i = 0; i < attemptsCount; i++) {
            movementCalculator.playGame(cars);
            consoleView.printPosition(cars);
        }

        List<String> winners = determineResult.getWinners(cars);
        consoleView.printWinner(winners);
    }
}
