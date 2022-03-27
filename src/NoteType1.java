public class NoteType1 extends Note {
    private int countLike; //Необходимо количество лайков
    private String annotations; //Пояснение к заметке


    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public NoteType1(String nameNote, String bodyNote, String author, int typeNote, int countLike, String annotations) {
        super(nameNote, bodyNote, author, typeNote);
        this.countLike = countLike;
        this.annotations=annotations;
    }
    @Override
    public String toString() {
        return "Название - " +getNameNote()+ ", Тело - " + getBodyNote()+ ", Автор - " + getAuthor()+ ", Тип заметки - " + getTypeNote() + ", Количество лайков - " + getCountLike() + ", Аннотация - "+ getAnnotations();
    }
}
