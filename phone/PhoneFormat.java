package phone;
//12
public class PhoneFormat {
    public static String makePhoneFormat(String number){
        String PhoneFormat;
        if (number.charAt(0) == '8'){
            PhoneFormat = "+7" + number.substring(1,4) + "-" + number.substring(4,7) + "-" + number.substring(7,9) + "-" + number.substring(9);
            return PhoneFormat;
        }
        else {
            StringBuffer buf = new StringBuffer(number);
            buf = buf.reverse();
            PhoneFormat = buf.substring(0,2) + "-" + buf.substring(2,4) + "-" + buf.substring(4,7) + "-" + buf.substring(7);
            buf = new StringBuffer(PhoneFormat);
            buf = buf.reverse();
            return buf.toString();
        }
    }

    public static void main(String[] args) {
        String russianNumb = "89257213666";
        System.out.println("Original number: " + russianNumb);
        System.out.println("New format:" + makePhoneFormat(russianNumb));
        String otherFormat = "+1232326661331";
        System.out.println("Original number:" + otherFormat);
        System.out.println("New format: " + makePhoneFormat(otherFormat));

    }
}
