package racingcar.model.domain;

import java.util.List;
import java.util.stream.Collectors;

public class DetermineResult {

    public List<String> getWinners(List<Car> cars) {
        return findWinners(cars);
    }

    private List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getCurrentPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
