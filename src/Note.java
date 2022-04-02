public abstract class Note implements NoteInterface{
    private String nameNote;
    private String bodyNote;
    private String author;
    private int typeNote;

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

    public String getBodyNote() {
        return bodyNote;
    }

    public void setBodyNote(String bodyNote) {
        this.bodyNote = bodyNote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(int typeNote) {
        this.typeNote = typeNote;
    }

    public Note(String nameNote, String bodyNote, String author, int typeNote) {
        this.nameNote = nameNote;
        this.bodyNote = bodyNote;
        this.author = author;
        this.typeNote = typeNote;
    }
    public String toString(){
        return "Название - " +getNameNote()+ ", Тело - " + getBodyNote()+ ", Автор - " + getAuthor()+ ", Тип заметки - " + getTypeNote() ;
    }
}
