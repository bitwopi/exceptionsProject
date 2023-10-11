import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    // Проверяет соответствует ли строка условиям задачи, т.е. есть ли в строке символы помимо
    // латинских и знака подчеркивания и привышает ли длина строки максимальную
    public static boolean checkString(String text){
        int maxLength = 20;
        return (text.length() > maxLength
                || Pattern.matches(".*\\W.*", text)
                || Pattern.matches(".*\\p{InCyrillic}.*", text));
    }

    // Выкидывает исключение если логин или пароль не соответсвуют условиям
    public static void loginUser(String login, String password, String confirmPassword){
        if (checkString(login)) {
            throw new WrongLoginException("Your login is incorrect, pls correct it!");
        }
        if (checkString(password) || !password.equals(confirmPassword)){
            throw new WrongPasswordException("You've entered the wrong password or your passwords don't match!");
        }

    }
    public static void main(String[] args) {
        try{
            loginUser("User_", "password_", "password_");
        }catch (WrongLoginException | WrongPasswordException e){
            System.out.println("Your login or password is incorrect!");
        }
    }
}