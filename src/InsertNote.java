import java.util.Arrays;
import java.util.Scanner;

public class InsertNote  {

    public static NoteInterface insertNotes(String val1, String val2, int val3, NoteInterface[] notes, int i) {
        NoteInterface result = null;
        Scanner scr = new Scanner(System.in);
        if (val3 == 1) {
            System.out.println("Введите Автора");
            String valAoutor = scr.nextLine();
            System.out.println("Введите количество лайков");
            int valLike = scr.nextInt();
            scr.nextLine();
            System.out.println("Введите Анатацию");
            String valAnot = scr.nextLine();
            notes[i] = new NoteType1(val1, val2, valAoutor, val3, valLike, valAnot);
            // System.out.println(notes.toString());
            result = new NoteType1(val1, val2, valAoutor, val3, valLike, valAnot);
        }
        if (val3 == 2) {
            System.out.println("Введите Автора");
            String valAoutor = scr.nextLine();
            System.out.println("Введите телефон");
            String valPhone = scr.nextLine();
            notes[i] = new NoteType2(val1, val2, valAoutor, val3, valPhone);
            //System.out.println(notes.toString());
            result = new NoteType2(val1, val2, valAoutor, val3, valPhone);
        }

        return result;
    }

    public static NoteInterface[] search(String search, NoteInterface[] notes) {
        NoteInterface[] note = new NoteInterface[notes.length];
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) continue;
            if (search.equals(notes[i].getNameNote()) || search.equals(Integer.toString(notes[i].getTypeNote()))) {
                note[i] = notes[i];
                //System.out.println(note[i]);
            }
        }
        return note;
    }


    public static int createNote(NoteInterface[] notes) {
        int i = 0;
        while (notes[i] != null && i++ < notes.length) {
        }
        return i;
    }

    public static int searchInt(NoteInterface[] noteSearch) {
        int j = 0;
        for (int i = 0; i < noteSearch.length; i++) {
            if (noteSearch[i] == null) {
                continue;
            }
            j = i;
        }
        return j;
    }

    public static void reWord(int j, NoteInterface[] noteSearch) {
        String searchWord;
        String updateWord;
        Scanner scr = new Scanner(System.in);

        System.out.println(" Тело заметки - "+noteSearch[j].getBodyNote());
        System.out.println("Введи слово значение которое хочешь заменить");
        searchWord = scr.next();
        System.out.println("Введи новое значение");
        updateWord= scr.next();
        String[] body = noteSearch[j].getBodyNote().split(" ");
        for (int i=0; i< body.length;i++){
            if (searchWord.equals(body[i])) {
                body[i]=updateWord;
            }
        }
        noteSearch[j].setBodyNote(Arrays.toString(body).replace(",", " ").replaceAll("[\\[\\]]", ""));
        System.out.println(noteSearch[j]);
    }
}
