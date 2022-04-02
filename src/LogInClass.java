import java.util.Scanner;

public class LogInClass {

    public static Users authorization(Users[] user) {
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
                return user[i];
            }
        }
        System.out.println("Невереный логин или пароль! Попробуйте снова.");
        return null;
    }
    public static boolean checkRole (Users checkAut,int numMenu, int numMenu2) throws AnyException {
        if (checkAut==null){
            throw new AnyException("Без авторизации, дейтвие недоступно! Авторизуйтесь.", false);
        }
        if ((numMenu==3 && checkAut.getRole().getLvlRoles()==3) || ((numMenu2==2 || numMenu2==3 || numMenu2==4) && checkAut.getRole().getLvlRoles()==3 )){
            throw new AnyException("Доступ для выполнения операции отсутствует!", false);
        }
        return true;
    }
}

