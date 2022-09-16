package sort;

public class sort {
    public static void sort(){

    }
    public static void main(String[] args){
        SortingStudentsByGPA sort = new SortingStudentsByGPA();
        System.out.println("Before sort:");
        System.out.println(sort);
        sort.sort(0,sort.getLength());
        System.out.println("After sort:");
        System.out.println(sort);

    }
}
