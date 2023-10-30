package racingcar.util;

public class GlobalExceptionHandler {

    public boolean isValidCarArray(String carArray) {
        if (carArray.contains(",")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidCarName(String carName) {
        if (carName.length()<=5) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidRacingCount(String racingCount) {
        try {
            Integer.parseInt(racingCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
