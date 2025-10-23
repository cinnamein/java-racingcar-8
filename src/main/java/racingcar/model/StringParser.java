package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(",", -1));
        for (String name : carNames) {
            validateCarName(name);
        }
        return carNames;
    }

    private void validateCarName(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백을 포함할 수 없습니다.");
        }
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }
}