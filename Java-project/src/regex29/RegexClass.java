package regex29;
import java.util.regex.Matcher;
//29
public class RegexClass {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuv18340";
        String s2 = "abcdefghijklmnoasdfasdpqrstuv18340";
        String regex = "abcdefghijklmnopqrstuv18340";
        Matcher matcher = java.util.regex.Pattern.compile(regex).matcher(s1);
        System.out.println(matcher.matches());
        matcher = java.util.regex.Pattern.compile(regex).matcher(s2);
        System.out.println(matcher.matches());
        String probel = "need to be splitted";
        String[] words = probel.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
