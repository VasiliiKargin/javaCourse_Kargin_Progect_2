import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flagIn = false;
        String search;
        Note[] notes = new Note[5];

        Scanner scr = new Scanner(System.in);
// Создаем пользователей
        Users user1 = new Users("ADMIN", "123", Roles.ADMIN);
        Users user2 = new Users("MODERATOR", "456", Roles.MODERATOR);
        Users user3 = new Users("CLIENT", "789", Roles.CLIENT);
// По дефолту создаем заметки
        notes[0] = new NoteType1("Выложить фотку", "Фотка должна быть \"огонь\"", "Семен", 1, 500, "Тут должна быть ваша анатация");
        notes[1] = new NoteType2("Статья", "Птицы в среде обитания", "Степа", 2, "8789465161");
        notes[2] = new NoteType2("Наработки по проекту", "Проработать алгоритм выполнения действий", "Женя", 2, "+79008883355");


        Menus.MyMenu();
        int numMenu = scr.nextInt();
        while (numMenu != 5) {
            if (numMenu == 1) {
                if (flagIn) {
                    System.out.println("Вы уже авторизованы!");
                } else {
                    while (!flagIn) {
                        flagIn = LogInClass.authorization(new Users[]{user1, user2, user3});
                    }
                }
            }
            if (numMenu == 2) {
                if (!flagIn) {
                    System.out.println("Вы еще не авторизовывались!");
                } else {
                    flagIn = false;
                    while (!flagIn) {
                        flagIn = LogInClass.authorization(new Users[]{user1, user2, user3});
                    }
                }
            }
            if (numMenu == 3) {
                System.out.println("Введите Название заметки");
                scr.nextLine();
                String val1 = scr.nextLine();
                System.out.println("Введите Тело заметки");
                String val2 = scr.nextLine();
                System.out.println("Введите Тип заметки");
                int val3 = scr.nextInt();
                int i = InsertNote.createNote(notes);
                //System.out.println(i);
                notes[i] = InsertNote.insertNotes(val1, val2, val3, notes, i);
                System.out.println(notes[i].toString()/* + " \n" + i*/);


            }
            if (numMenu == 4) {
                System.out.println("Введите название или тип заметки");
                search = scr.next();
                Note[] noteSearch = InsertNote.search(search, notes);
                //for (int j=0;j<noteSearch.length; j++){
                    System.out.println(noteSearch.toString());
                //}

            }
            Menus.MyMenu();
            numMenu = scr.nextInt();
        }
        System.out.println("До свидания!");
    }
}
