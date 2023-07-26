public class MonthData {
    int[] days;

    MonthData() {
        days = new int[30];
    }

    void printDaysAndStepsFromMonth(MonthData[] monthToData, int n) {;
        for (int i = 0; i < days.length; i++) {
            System.out.println((i+1) + " день: " + monthToData[n-1].days[i]);// Вывод элементов массива в необходимом формате
            }
    }

    int sumStepsFromMonth(MonthData[] monthToData, int n) {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += monthToData[n-1].days[i];// подсчёт суммы элементов массива days[]
        }
        return sumSteps;
    }

    int maxSteps(MonthData[] monthToData, int n) {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (monthToData[n-1].days[i] > maxSteps){
                maxSteps = monthToData[n-1].days[i];// поиск максимального элемента
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay, MonthData[] monthToData, int n) {
        int currentSeries = 0;
        int bestSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (monthToData[n-1].days[i] >= goalByStepsPerDay){
                currentSeries++;
                if (currentSeries > bestSeries){
                    bestSeries = currentSeries;
                }
            }else {
                currentSeries = 0;
            }// поиск максимальной серии
        }
        return bestSeries;
    }
    int averageNumber(MonthData[] monthToData, int n){
        int daySum = 0;
        for (int i = 0; i < days.length; i++){
            daySum += monthToData[n-1].days[i];
        }
        int averageNumber = daySum / 30;
        return averageNumber;
    }
}
