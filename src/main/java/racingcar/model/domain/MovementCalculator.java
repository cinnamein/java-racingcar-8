package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MovementCalculator {

    public void playGame(List<Car> cars) {
        for (Car car : cars) {
            carAction(car);
        }
    }

    private void carAction(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.move();
        }
    }
}
