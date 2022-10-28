package sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator <Student> {

    SortingStudentsByGPA(){

    }
    public void sort(Student []st, int low,int high){
        if (low>=high)
            return;

        int med = low + (high-low)/2;
        Student center = st[med];
        int i = low;
        int j = high;
        while (i<=j){
            while (compare(st[i],center)==1){
                i++;
            }
            while (compare(st[j],center)==0){
                j--;
            }
            if (i <=j){
                swap(st,i,j);
                i++;
                j--;
            }
        }
        if (low < j)
            sort(st,low,j);
        if (high > i)
            sort(st,i,high);
            //sort(low,med);
            //sort(med+1,high);

    }

    private void swap(Student[] st,int i, int j){
        Student c = st[i];
        st[i] = st[j];
        st[j] = c;
    }


    @Override
    public int compare(Student o1, Student o2) {
        if (o1.mark == o2.mark)
            return -1;
        else if (o1.mark > o2.mark)
            return 1;
        else return 0;
    }
}