import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Выполняется команда 1");
                    break;
                case 2:
                    System.out.println("Выполняется команда 2");
                    break;
                case 3:
                    System.out.println("Выполняется команда 3");
                    break;
                case 0:
                    System.out.println("Работа с приложением завершена.");
                    return;
                default:
                    System.out.println("К сожалению, такой команды пока нет!");
                    break;
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберите комманду и введите её номер: ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день;");
        System.out.println("3 - Показать статистику за определённый месяц;");
        System.out.println("0 - Выход");
    }

} 