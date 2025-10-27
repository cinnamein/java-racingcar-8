package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.util.InputValidator;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        this.inputValidator = new InputValidator();
    }

    @Test
    void 자동차명_문자열_입력_테스트() {
        assertDoesNotThrow(() -> inputValidator.validateInputString("cinna,mein"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // 입력값이 공백이거나 null인 경우
            "", " ", "\n",
    })
    // 입력값이 1024자를 초과하는 경우
    @MethodSource("createOverSizedString")
    void 자동차명_문자열_입력_예외_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_문자열_입력_테스트() {
        assertDoesNotThrow(() -> inputValidator.validateAttemptsCount(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            // n이 2147483647 이하의 자연수가 아닌 경우
            0, -1
    })
    void 시도횟수_문자열_입력_예외_테스트(int attemptCountInput) {
        assertThatThrownBy(() -> inputValidator.validateAttemptsCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> createOverSizedString() {
        String overSizedString = "a,".repeat(513);
        return Stream.of(overSizedString);
    }
}
