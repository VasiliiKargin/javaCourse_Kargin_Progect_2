public class NoteType3 extends Note {
private String telephone; //Телефон автора

    public NoteType3(String nameNote, String bodyNote, String author, int typeNote,String telephone) {
        super(nameNote, bodyNote, author, typeNote);
        this.telephone=telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
