import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    MonthData monthData = new MonthData();
    int goalByStepsPerDay = 10_000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Указан некорректный номер месяца. Введите номер месяца от 1 до 12");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Указан некорректный номер дня. Введите номер дня от 1 до 30");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Указано неверное значение. Количество шагов не может быть отрицательным");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println("Количество шагов успешно записано!");
    }

    void changeStepGoal(int newDailyGoal) {
        goalByStepsPerDay = newDailyGoal;
        System.out.println("Новая цель успешно сохранена! Теперь ежедневная цель составляет " + goalByStepsPerDay
                + " шагов.");
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Указан некорректный номер месяца. Введите номер месяца от 1 до 12");
            return;
        }
        monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Ваша статистика за выбранный месяц:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Всего за месяц вы прошли " + sumSteps + " шагов");
        System.out.println("Максимальное пройденное количество шагов в день: " + monthData.maxSteps());
        System.out.println("Среднее количество пройденный шагов в день за месяц: "
                + (sumSteps / monthData.days.length));
        System.out.println("Пройденная за месяц дистанция составила " + converter.convertToKm(sumSteps) + " километров");
        System.out.println("Всего за месяц при ходьбе вы сожгли " + converter.convertStepsToKilocalories(sumSteps)
                + " килокалорий");
        System.out.println("Лучшая серия по достижению цели составила " + monthData.bestSeries(goalByStepsPerDay)
                + " дней подряд");
        System.out.println();
    }
} 