import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String login;
        String password;
        boolean flagIn = false;

        Scanner scr = new Scanner(System.in);
// Создаем пользователей
        Users user1 = new Users("ADMIN", "123", Roles.ADMIN);
        Users user2 = new Users("MODERATOR", "456", Roles.MODERATOR);
        Users user3 = new Users("CLIENT", "789", Roles.CLIENT);
// По дефолту создаем заметки
        NoteType1 note1 = new NoteType1("Выложить фотку", "Фотка должна быть \"огонь\"", "Семен", 1, 500);
        NoteType2 note2 = new NoteType2("Статья", "Птицы в среде обитания", "Степа", 2, "Написать статью");
        NoteType3 note3 = new NoteType3("Наработки по проекту", "Проработать алгоритм выполнения действий", "Женя", 3, "+79008883355");

        Menus.MyMenu();
        int numMenu = scr.nextInt();
        while (numMenu != 5) {
            if (numMenu == 1) {
                if (flagIn) {
                    System.out.println("Вы уже авторизованы!");
                } else {
                    while (!flagIn) {
                        flagIn=LogInClass.authorization( new Users[]{user1, user2, user3});
                    }
                }
            }
            if (numMenu == 2) {
                flagIn=false;
                while (!flagIn) {
                    flagIn=LogInClass.authorization( new Users[]{user1, user2, user3});
                }
            }
            if (numMenu == 3) {
                System.out.println("Создание новой заметки");
                break;
            }
            if (numMenu == 4) {
                System.out.println("Поиск заметки");
                break;
            }
            Menus.MyMenu();
            numMenu = scr.nextInt();
        }
        System.out.println("До свидания!");
    }
}
