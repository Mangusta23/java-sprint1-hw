public class Converter {
    final double ONE_STEP = 0.00075;
    final double KKAL = 0.05;
    int convertToKm(int sumSteps){
        int distance = (int) (sumSteps * ONE_STEP); // Прописал через константу
        return distance;
    }

    int convertStepsToKilocalories(int sumSteps){
        int kkal = (int) (sumSteps * KKAL);        // Прописал через константу
        return kkal;
    }
}
