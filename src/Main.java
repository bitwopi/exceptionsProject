import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {

    // Выкидывает исключение если логин или пароль не соответсвуют условиям
    public static void loginUser(String login, String password, String confirmPassword){
        try {
            if (!Pattern.matches("^[a-zA-Z0-9_]{1,20}$", login)) {
                throw new WrongLoginException("Your login is incorrect, pls correct it!");
            }
            if (!Pattern.matches("^[a-zA-Z0-9_]{1,19}$", password) || !password.equals(confirmPassword)){
                throw new WrongPasswordException("You've entered the wrong password or your passwords don't match!");
            }
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
        }


    }
    public static void main(String[] args) {
        loginUser("User_", "1111111111111111111", "1111111111111111111");
    }
}