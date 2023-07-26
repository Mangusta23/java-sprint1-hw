import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker(scanner);
        MonthData monthData = new MonthData();
        int goalByStepsPerDay = 10000;

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal(goalByStepsPerDay);
            } else if (command == 3) {
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
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определенный месяц");
        System.out.println("0 - Выход");
    }
}