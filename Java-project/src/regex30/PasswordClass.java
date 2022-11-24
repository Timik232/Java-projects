package regex30;
//30
import java.util.regex.Matcher;

public class PasswordClass {
    public static void passwordCheck(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        Matcher matcher = java.util.regex.Pattern.compile(regex).matcher(password);
        if (matcher.matches()) {
            System.out.println("Password is strong");
        }
        else {
            System.out.println("Password is weak");
        }
    }

    public static void main(String[] args) {
        passwordCheck("Password1!");
        passwordCheck("password1!");
        passwordCheck("Password!");
        passwordCheck("ser13volk");
        passwordCheck("Ser_13_volk");
    }
}
