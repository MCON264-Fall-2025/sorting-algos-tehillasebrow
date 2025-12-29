package edu.touro.mcon264.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement merge sort

        if(a.length==0 || a.length==1){
        return;}

            //split the array into halves
            int middle = a.length/2;
            T [] left= (T[]) new Object[middle];
            T [] right= (T[]) new Object[a.length-middle];
        System.arraycopy(a, 0, left, 0, middle);
        if (a.length - middle >= 0) System.arraycopy(a, middle, right, 0, a.length - middle);
        sort(left,comp);
        sort(right,comp);
        int leftIndex=0;
        int rightIndex=0;
        int i=0;
        while(leftIndex<left.length && rightIndex<right.length){
           if(comp.compare(left[leftIndex],right[rightIndex])<=0){
               a[i]=left[leftIndex];
                leftIndex++;
           }
           else{
               a[i]=right[rightIndex];
               rightIndex++;
           }
           i++;
        }
        while(leftIndex<left.length){
            a[i]=left[leftIndex];
            leftIndex++;
            i++;
        }
        while(rightIndex<right.length){
            a[i]=right[rightIndex];
            rightIndex++;
            i++;
        }
        }

    }
