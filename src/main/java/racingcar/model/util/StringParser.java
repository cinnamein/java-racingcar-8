package racingcar.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringParser {

    public List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = Arrays.asList(carNamesInput.split(",", -1));
        validateDuplication(carNames);
        for (String name : carNames) {
            validateCarName(name);
        }
        return carNames;
    }

    public int parseAttemptsCount(String attemptsCountString) {
        int attemptsCount;
        try {
            attemptsCount = Integer.parseInt(attemptsCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시행 횟수는 2147483647 이하의 자연수만 가능합니다.");
        }
        return attemptsCount;
    }

    private void validateDuplication(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
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