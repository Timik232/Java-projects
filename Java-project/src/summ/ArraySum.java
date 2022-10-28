package summ;
//18
public class ArraySum {
    public static int forSum(int[] arr){
        int sum = 0;
        for (int i = 0;i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static int whileSum(int[] arr){
        int sum = 0;
        int count = 0;
        while (count<arr.length){
            sum+=arr[count];
            count+=1;
        }
        return sum;
    }
    public static int doWhileSum(int[] arr){
        int sum = 0;
        int count = 0;
        do {
            sum+=arr[count];
            count+=1;
        } while (count<arr.length);
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i]=i;
        }
        System.out.println("For sum: " + forSum(arr));
        System.out.println("While sum: " + whileSum(arr));
        System.out.println("Do while sum: " + doWhileSum(arr));
    }
}
