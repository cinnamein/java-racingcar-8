package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.domain.Car;

public class ConsoleView {

    public String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String getAttemptsCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsCount = Console.readLine();
        System.out.println("실행 결과");
        return attemptsCount;
    }

    public void printPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionString());
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String output = formatWinnerOutput(winners);
        System.out.println(output);
        Console.close();
    }

    private String formatWinnerOutput(List<String> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (String winner : winners) {
            result.append(winner).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}
