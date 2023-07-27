import java.util.Scanner;
class StepTracker {
    Scanner scanner;
    static MonthData[] monthToData = new MonthData[12];
    int goalStepPerDay;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay(){
        int m;
        while(true) {
            System.out.println("Введите номер месяца: 1-ЯНВ. 3-МАР. 5-МАЙ.  7-ИЮЛЬ. 9-СЕН.  11-НОЯ.");
            System.out.println("                      2-ФЕВ. 4-АПР. 6-ИЮНЬ. 8-АВГ.  10-ОКТ. 12-ДЕК.");
            m = scanner.nextInt();
            System.out.println("Вы выбрали: " + m);
            System.out.println("1 - Подтвердить");
            System.out.println("2 - Выбрать другой месяц");
            int x = scanner.nextInt();
            if (x == 1){          // Добавил возможность верутся к выбору месяца в случае ошибки
                break;
            }
        }
        while (m > 12 || m < 1){
            System.out.println("Некоректное значение месяца.");
            m = scanner.nextInt();
            }// ввод и проверка номера месяца
        System.out.println("Введите день от 1 до 30 (включительно)");
        int d = scanner.nextInt();
        while (d < 1 || d > 30){
            System.out.println("Некоректное значение дня.");
            d = scanner.nextInt();
        }
        // ввод и проверка дня

        System.out.println("Введите количество шагов");
        int s = scanner.nextInt();
        while (s < 0){
            System.out.println("Некоректное значение пройденных шагов.");
            s = scanner.nextInt();
        }// ввод и проверка количества шагов

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[m-1];
        // Сохранение полученных данных
        monthData.days[d-1] = s;
        monthToData[m-1] = monthData;
    }

    void changeStepGoal(int goalByStepsPerDay){
        System.out.println("Введите цель по шагам в день. Цель шагов должна быть больше 0");
        int x = scanner.nextInt();
        if (x <= 0){
            System.out.println("Некоректное значение шагов.");
        }else{
            goalStepPerDay = x;
        }
    }

    void printAllStatistic(MonthData monthData, Converter converter, int goalByStepsPerDay){ // Перенес вывод статистики в StepTracker
        System.out.println("Введите номер месяца: 1-ЯНВ. 3-МАР. 5-МАЙ.  7-ИЮЛЬ. 9-СЕН.  11-НОЯ.");
        System.out.println("                      2-ФЕВ. 4-АПР. 6-ИЮНЬ. 8-АВГ.  10-ОКТ. 12-ДЕК.");
        int n = scanner.nextInt();
        System.out.println("Количество пройденных шагов по дням:");
        monthData.printDaysAndStepsFromMonth(StepTracker.monthToData, n);
        System.out.println("Сумма пройденных шагов за месяц " + monthData.sumStepsFromMonth(StepTracker.monthToData, n));
        System.out.println("Максимальное пройденное количество шагов в месяц: " + monthData.maxSteps(StepTracker.monthToData, n));
        System.out.println("В среднем пройденно шагов в день: " + monthData.averageNumber(StepTracker.monthToData, n));
        System.out.println("Пройдено киломентров: " + converter.convertToKm(monthData.sumStepsFromMonth(StepTracker.monthToData, n)));
        System.out.println("Сожжено килокалорий: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth(StepTracker.monthToData, n)));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay, StepTracker.monthToData, n));
    }
}
