package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                }, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트_자동차명_공백_혹은_빈값() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차명_공백_포함() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,me in", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차명_빈값_선두_쉼표() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",cinna,mein", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차명_빈값_중위_쉼표() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,,mein", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차명_빈값_후위_쉼표() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,mein,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차명_5자_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cin,namein", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차명_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,cinna", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_0_이하() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,mein", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_최대값_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,mein", "2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도횟수_문자() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("cinna,mein", "a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
