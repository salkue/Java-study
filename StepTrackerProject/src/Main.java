import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 4) {
            // обработка разных случаев


            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день;\n"+
                "2. Напечатать статистику за определенный месяц;\n"+
                "3. Изменить цель по количеству шагов в день;\n"+
                "4. Выйти из приложения.");
    }
}