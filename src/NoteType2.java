public class NoteType2 extends Note {
private String action; //Что необходимо сделать по заметке

    public NoteType2(String nameNote, String bodyNote, String author, int typeNote,String action) {
        super(nameNote, bodyNote, author, typeNote);
        this.action=action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
