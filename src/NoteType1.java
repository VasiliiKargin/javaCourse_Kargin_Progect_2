public class NoteType1 extends Note {
    private int countLike; //Необходимо количество лайков
    private String annotation; //Пояснение к заметке


    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public NoteType1(String nameNote, String bodyNote, String author, int typeNote, int countLike) {
        super(nameNote, bodyNote, author, typeNote);
        this.countLike = countLike;

    }
}
