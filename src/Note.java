public abstract class Note {
    private String nameNote;
    private String bodyNote;
    private String author;
    private int typeNote;

    public Note(String nameNote, String bodyNote, String author, int typeNote) {
        this.nameNote = nameNote;
        this.bodyNote = bodyNote;
        this.author = author;
        this.typeNote = typeNote;
    }
}
