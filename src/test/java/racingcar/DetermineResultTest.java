package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.DetermineResult;

class DetermineResultTest {

    private DetermineResult determineResult;
    private Car cinna;
    private Car mein;

    @BeforeEach
    void setUp() {
        this.determineResult = new DetermineResult();
        this.cinna = new Car("cinna");
        this.mein = new Car("mein");
    }

    @Test
    void 단독_우승자_판별_테스트() {
        cinna.move();
        List<Car> cars = List.of(cinna, mein);
        List<String> winners = determineResult.getWinners(cars);
        assertThat(winners).containsExactlyInAnyOrder("cinna");
    }

    @Test
    void 공동_우승자_판별_테스트() {
        cinna.move();
        mein.move();
        List<Car> cars = List.of(cinna, mein);
        List<String> winners = determineResult.getWinners(cars);
        assertThat(winners).containsExactlyInAnyOrder("cinna", "mein");
    }

    @Test
    void 전원_0점_공동_우승자_판별_테스트() {
        List<Car> cars = List.of(cinna, mein);
        List<String> winners = determineResult.getWinners(cars);
        assertThat(winners).containsExactlyInAnyOrder("cinna", "mein");
    }
}
