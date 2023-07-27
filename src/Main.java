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
            switch (command){
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal(goalByStepsPerDay);
                    break;
                case 3:
                    stepTracker.printAllStatistic(monthData, converter, goalByStepsPerDay);
                    break;
                case 0:
                    System.out.println("Выход");
                    return;
                default:
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