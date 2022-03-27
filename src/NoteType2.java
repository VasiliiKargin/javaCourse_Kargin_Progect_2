public class NoteType2 extends Note {
private String telephone; //Телефон автора

    public NoteType2(String nameNote, String bodyNote, String author, int typeNote, String telephone) {
        super(nameNote, bodyNote, author, typeNote);
        this.telephone=telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Название - " +getNameNote()+ ", Тело - " + getBodyNote()+ ", Автор - " + getAuthor()+ ", Тип заметки - " + getTypeNote() + ", Телефон - " + getTelephone();
    }
}
