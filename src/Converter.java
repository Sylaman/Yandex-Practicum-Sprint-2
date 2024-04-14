class Converter {

    final int cmPerStep = 75;
    final int calPerStep = 50;

    int convertToKm(int steps) {
        return steps * cmPerStep / 100_000;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * calPerStep / 1_000;
    }
}