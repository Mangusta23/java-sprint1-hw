public class Converter {

    int convertToKm(int sumSteps){
        int distance = sumSteps * 3 / 4;
        return distance;
    }

    int convertStepsToKilocalories(int sumSteps){
        int kkal = sumSteps * 5 / 100;
        return kkal;
    }
}
