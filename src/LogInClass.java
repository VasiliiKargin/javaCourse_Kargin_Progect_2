import java.util.Scanner;

public class LogInClass {

    public static boolean authorization(Users[] user) throws AnyException {
        String login;
        String password;
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите логин!");
        login = scr.next();
        System.out.println("Введите пароль.");
        password = scr.next();
        for (int i = 0; i < user.length; i++) {
            if (login.equals(user[i].getLogin()) && password.equals(user[i].getPassword())) {
                System.out.println("Добро пожаловать " + user[i].getRole().getName());
                return true;
            }
        }
        System.out.println("Невереный логин или пароль! Попробуйте снова.");
        return false;
    }
}

