package sort;

import java.util.Arrays;

public class SortingStudentsByGPA implements Comparator {
    private String []names = {"Vladimir", "Vlad", "Andrey", "Michail", "Sergey", "Anna","Ksenia"};
    private double []marks = {4.9,4.0,5.0,3.5,3.0,4.3,4.2};
    SortingStudentsByGPA(){

    }
    public void sort(int low,int high){
    if (low < high)
        {
            int med = mediana(low,high);
            sort(low,med);
            sort(med+1,high);
        }
    }
    public int mediana(int low, int high){
        double number = marks[high];
        int i = low;
        for (int j = low+1; j < high-1; j++)
        {
            if (marks[j]>number) {
                System.out.println(marks[i]);
                System.out.println(marks[j]);
                swapp(marks[i],marks[j]);
                System.out.println(marks[i]);
                swapp(names[i],names[j]);
                i+=1;
            }
        }
        swapp(marks[i],marks[high]);
        swapp(names[i],names[high]);
        return i;
    }
    private void swap(Object a, Object b){
    Object c = a;
    a = b;
    b = c;
    }
    private <T> void swapp(T a,T b){
        T c = a;
        a = b;
        b = c;
    }
    @Override
    public String toString() {
        return "SortingStudentsByGPA{" +
                "names=" + Arrays.toString(names) +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
    public int getLength(){
        return names.length - 1;
    }
}
