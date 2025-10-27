package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.MovementCalculator;

class MovementCalculatorTest {

    private MovementCalculator movementCalculator;
    private Car cinna;
    private Car mein;

    @BeforeEach
    void setUp() {
        this.movementCalculator = new MovementCalculator();
        this.cinna = new Car("cinna");
        this.mein = new Car("mein");
    }

    @Test
    void 자동차_전진_및_정지_혼합_테스트() {
        List<Car> cars = List.of(cinna, mein);
        assertRandomNumberInRangeTest(() -> {
                    movementCalculator.playGame(cars);
                    assertThat(cinna.getCurrentPosition()).isEqualTo(1);
                    assertThat(mein.getCurrentPosition()).isZero();
                }, 4, 3
        );
    }
}
