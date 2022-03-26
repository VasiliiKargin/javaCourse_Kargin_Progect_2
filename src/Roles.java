public enum Roles {
    ADMIN("Администратор",1),
    MODERATOR("Модератор",2),
    CLIENT("Пользователь",3);

    private final String name;
    private final int lvlRoles;

    public String getName() {
        return name;
    }

    public int getLvlRoles() {
        return lvlRoles;
    }

    Roles(String name, int lvlRoles) {
        this.name = name;
        this.lvlRoles = lvlRoles;
    }
}
