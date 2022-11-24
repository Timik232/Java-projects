package except26;

import java.util.Scanner;

public class DemoExcept {
    /*public class ThrowsDemo {
        public void getDetails(String key) {
            if(key == null) {
                throw new NullPointerException( "null key in getDetails" );
            }

        }
    }*/



    public void getKey() {
        Scanner myScanner = new Scanner( System.in );
        while(true){
            System.out.print("Enter Key ");
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                break;
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message ); }
    private String getDetails(String key) throws Exception {
        if(key.equals("") || (key.equals(" "))) {
            throw new Exception( "Key set to empty string" );
        }
        else if (key.length() < 4) {
            throw new Exception( "Key is too short" );
        }
        return "data for " + key;
    }
    public static void main(String[] args) {
        DemoExcept demo = new DemoExcept();
        demo.getKey();
    }
}