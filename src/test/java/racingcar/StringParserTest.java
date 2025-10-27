package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.util.StringParser;

class StringParserTest {

    private StringParser stringParser;

    @BeforeEach
    void setUp() {
        this.stringParser = new StringParser();
    }

    @Test
    void 자동차명_파싱_테스트() {
        List<String> carNames = stringParser.parseCarNames("cinna,mein");
        assertThat(carNames).containsExactly("cinna", "mein");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // 자동차명이 쉼표나 공백을 포함하거나, 5자를 초과하는 경우
            "cinna,,mein", "cinna,me in", "cinna, ,mein", "cin ,na,mein", "cinnamein",
            // 쉼표 앞, 사이, 뒤에 이름이 없는 경우
            ",cinna,mein", "cinna,mein,", ",cinna,mein,",
            // 동일한 자동차명이 입력된 경우
            "cinna,cinna,mein"
    })
    void 자동차명_파싱_예외_테스트(String carNamesInput) {
        assertThatThrownBy(() -> stringParser.parseCarNames(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // n이 2147483647 이하의 자연수가 아닌 경우
            "test", "@", " ", "2147483648"
    })
    void 시도횟수_테스트(String attemptCountInput) {
        assertThatThrownBy(() -> stringParser.parseAttemptsCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
