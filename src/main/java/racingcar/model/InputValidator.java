package racingcar.model;

public class InputValidator {

    public void validateInputString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차는 무조건 한 대 이상 입력되어야 합니다.");
        }
        if (input.length() > 1024) {
            throw new IllegalArgumentException("입력 문자열은 1024자를 초과할 수 없습니다.");
        }
    }

    public void validateAttemptsCount(int attemptCount) {
        if (attemptCount > 2147483647 || attemptCount <= 0) {
            throw new IllegalArgumentException("시행 횟수는 2147483647 이하의 자연수만 가능합니다.");
        }
    }
}
