package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.util.GlobalExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.RacingCarConst.AHEAD_LIMIT;

class RacingCarServiceTest {

    final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    Car one = new Car("one");
    Car two = new Car("two");
    Car three = new Car("three");
    Car four = new Car("four");

    @Test
    void 참가하는_자동차_이름_문자열_받아와_리스트로_변환() {
        final String cars = "one,two,three,four";
        List<String> carArray = new ArrayList<>();

        if (globalExceptionHandler.isValidCarArray(cars)){
            carArray = List.of(cars.split(","));
        }

        assertThat(carArray).containsExactly("one", "two", "three", "four");
    }

    @Test
    void 참가하는_자동차_이름_리스트_받아와_객체_생성하기(){
        final List<String> racingCars = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        List<Car> carList = new ArrayList<>();

        for (int i=0; i<racingCars.size(); i++){
            if (globalExceptionHandler.isValidCarName(racingCars.get(i))) {
                final Car car = new Car(racingCars.get(i));
                carList.add(car);
            }
        }

        List<Car> result = new ArrayList<>(Arrays.asList(one, two, three, four));
        for (Car resultCar:result) {
            Car car = carList.get(result.indexOf(resultCar));
            assertThat(car).usingRecursiveComparison().isEqualTo(resultCar);
        }
    }

    @Test
    void 자동차_경주_객체_생성하기() {
        final String racingCount = "4";
        List<Car> racingCarList = new ArrayList<Car>(Arrays.asList(one, two, three, four));
        Racing racingGame = null;

        if (globalExceptionHandler.isValidRacingCount(racingCount)) {
            racingGame = new Racing(racingCarList, Integer.parseInt(racingCount));
        }

        Racing result = new Racing(Arrays.asList(one, two, three, four), 4);
        assertThat(racingGame).usingRecursiveComparison().isEqualTo(result);
    }

    @Test
    void 전진_횟수_세기() {
        Car car = new Car("one");
        int[] randomList = {0, 8, 5, 3};

        for (int random:randomList){
            if (random>=AHEAD_LIMIT){
                car.updateAheadCount();
            }
        }

        assertThat(car.getAheadCount()).isEqualTo(2);
    }

    @Test
    void startRacingRound() {
    }

    @Test
    void getAheadCountList() {
    }

    @Test
    void updateWinnerList() {
    }
}