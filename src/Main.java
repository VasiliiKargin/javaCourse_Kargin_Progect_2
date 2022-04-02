import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AnyException {
        boolean flagIn = false;
        String search;
        Note[] notes = new Note[5];
        Note searchOne;
        int j = 0;
        Users checkAut = null;

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
                if (checkAut != null) {
                    System.out.println("Вы уже авторизованы!");
                } else {
                    while (checkAut == null) {
                        checkAut = LogInClass.authorization(new Users[]{user1, user2, user3});
                    }
                }
            }
            if (numMenu == 2) {
                if (checkAut == null) {
                    System.out.println("Вы еще не авторизовывались!");
                } else {
                    checkAut = null;
                    while (checkAut == null) {
                        checkAut = LogInClass.authorization(new Users[]{user1, user2, user3});
                    }
                }
            }
            if (numMenu == 3) {
                try {
                    flagIn = LogInClass.checkRole(checkAut,numMenu,0);
                } catch (AnyException ae) {
                    System.out.println(ae.getMessage());
                    flagIn=false;
                }
                if (!flagIn) {
                    numMenu=0;
                    continue;
                }
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
                try {
                    flagIn = LogInClass.checkRole(checkAut,numMenu,0);
                } catch (AnyException ae) {
                    System.out.println(ae.getMessage());
                    flagIn=false;
                }
                if (!flagIn) {
                    numMenu=0;
                    continue;
                }
                System.out.println("Введите название или тип заметки");
                search = scr.next();
                Note[] noteSearch = InsertNote.search(search, notes);

                int count = 0;
                for (int i = 0; i < noteSearch.length; i++) {
                    if (noteSearch[i] == null) {
                        continue;
                    }
                    count++;
                    //System.out.println(noteSearch[i]);
                }
                if (count > 1) {

                    System.out.println("Обнаружено несколько значений по поиску. Необходимо одно значение. Продолжим поиск?(Нажми 1 чтобы продолжить поиск.)");
                    int next = scr.nextInt();
                    if (next == 1) {
                        continue;
                    }
                    numMenu = 0;
                    continue;
                }
                if (count == 0) {
                    System.out.println("Ничего не найдено! Попробуйте снова.");
                    continue;
                } else {
                    j = InsertNote.searchInt(noteSearch);
                    Menus.MyMenu2();
                    int numMenu2;
                    numMenu2 = scr.nextInt();
                    switch (numMenu2) {
                        case 1:
                            System.out.println(notes[j]);
                            numMenu2=0;
                            break;
                        case 2:
                            try {
                                flagIn = LogInClass.checkRole(checkAut,numMenu,numMenu2);
                            } catch (AnyException ae) {
                                System.out.println(ae.getMessage());
                                flagIn=false;
                            }
                            if (!flagIn) {
                                numMenu=0;
                                continue;
                            }
                            String update;
                            update = scr.nextLine();
                            notes[j].setNameNote(update);
                            System.out.println(notes[j]);
                            break;
                        case 3:
                            try {
                                flagIn = LogInClass.checkRole(checkAut,numMenu,numMenu2);
                            } catch (AnyException ae) {
                                System.out.println(ae.getMessage());
                                flagIn=false;
                            }
                            if (!flagIn) {
                                numMenu=0;
                                continue;
                            }
                            InsertNote.reWord(j, notes);
                            break;
                        case 4:
                            try {
                                flagIn = LogInClass.checkRole(checkAut,numMenu,numMenu2);
                            } catch (AnyException ae) {
                                System.out.println(ae.getMessage());
                                flagIn=false;
                            }
                            if (!flagIn) {
                                numMenu=0;
                                continue;
                            }
                            String updateBody;
                            updateBody = scr.nextLine();
                            notes[j].setBodyNote(updateBody);
                            System.out.println(notes[j]);
                            break;
                        case 5:
                            System.out.println(notes[j].getAuthor());
                            break;
                        case 6:
                            notes[j] = null;
                            System.gc();
                            break;
                    }
                }
            }
            Menus.MyMenu();
            numMenu = scr.nextInt();
        }
        System.out.println("До свидания!");
    }
}
