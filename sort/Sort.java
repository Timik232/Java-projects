package sort;

public class Sort {
    public static void Sort(){

    }
    public static void main(String[] args){
         String[] names = {"Vladimir", "Vlad", "Andrey", "Michail", "Sergey", "Anna","Ksenia"};
         double[] marks = {4.9,4.0,5.0,3.5,3.0,4.3,4.2};
         Student[] schoolClass = new Student[7];
         for (int i = 0; i < 7; i++){
             Student st = new Student(names[i],marks[i]);
             schoolClass[i] = st;
         }
        SortingStudentsByGPA sort = new SortingStudentsByGPA();
        System.out.println("Before sort:");
        //System.out.println(sort);
        for (Student S: schoolClass){
            System.out.println(S);
        }
        sort.sort(schoolClass,0,schoolClass.length-1);
        System.out.println();
        System.out.println("After sort:");
        for (Student S: schoolClass){
            System.out.println(S);
        }
        //System.out.println(sort);

    }
}