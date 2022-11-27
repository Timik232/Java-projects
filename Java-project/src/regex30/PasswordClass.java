package regex30;
//30
import java.util.regex.Matcher;

public class PasswordClass {
    public static void passwordCheck(String password) {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        Matcher matcher = java.util.regex.Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            System.out.println("Password " + password + " is strong");
        }
        else {
            System.out.println("Password " + password + " is weak");
        }
    }

    public static void main(String[] args) {
        passwordCheck("Password1!");
        passwordCheck("password1!");
        passwordCheck("Password!");
        passwordCheck("too_weak_password");
        passwordCheck("TOO_strong_password123");
    }
}
