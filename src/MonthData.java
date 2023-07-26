public class MonthData {
    int[] days;
    int[] monthData;
    int[] daysValue;
    int n;

    MonthData() {
        days = new int[30];
    }
    void printDaysAndStepsFromMonth(int n) {
        MonthData daysValue = monthData[n];
        for (int i = 0; i < days.length; i++) {
            System.out.println((i+1) + " день: " + daysValue[i]);// Вывод элементов массива в необходимом формате
            }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];// подсчёт суммы элементов массива days[]
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps){
                maxSteps = days[i];// поиск максимального элемента
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int bestSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > goalByStepsPerDay){
                currentSeries = currentSeries + 1;
                if (currentSeries > bestSeries){
                    bestSeries = currentSeries;
                }
            }// поиск максимальной серии
        }
        return bestSeries;
    }
    int averageNumber(){
        int daySum = 0;
        for (int i = 0; i < days.length; i++){
            daySum = daySum + days[i];
        }
        int averageNumber = daySum / 30;
        return averageNumber;
    }
}
