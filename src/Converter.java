public class Converter {

    int convertToKm(int steps){
        int distance = (int) (steps * 0.75);
        return distance;
    }

    int convertStepsToKilocalories(int steps){
        int kkal = (int) (steps * 0.05);
        return kkal;
    }
}
