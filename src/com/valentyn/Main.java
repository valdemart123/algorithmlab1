package com.valentyn;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        Integer [] searchArray = generator();
        Integer findValue = returnFindElement(searchArray);

        //Check the time linear search
        long nanos = System.nanoTime();
        int result = linearSearch(searchArray, findValue);
        long duration = System.nanoTime() - nanos;
        int seconds = (int) (duration / 1000000000);
        int milliseconds = (int) (duration / 1000000) % 1000;
        int nanoseconds = (int) (duration % 1000000);
        System.out.println("Result for linear search ");
        System.out.printf("%d seconds, %d milliseconds en %d nanoseconds\n", seconds, milliseconds, nanoseconds);
        System.out.println("Result: " + findValue);

        //Check the time binary search
        long nanos2 = System.nanoTime();
        int result2 = binarySearch(searchArray, findValue);
        long duration2 = System.nanoTime() - nanos2;
        int seconds2 = (int) (duration2 / 1000000000);
        int milliseconds2 = (int) (duration2 / 1000000) % 1000;
        int nanoseconds2 = (int) (duration2 % 1000000);
        System.out.println("Result for binary search ");
        System.out.printf("%d seconds, %d milliseconds en %d nanoseconds\n", seconds2, milliseconds2, nanoseconds2);
        System.out.println("Result: " + findValue);


    }

    public static Integer [] generator () {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<21474836; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<21474835; i++) {
            list.get(i);
        }
        Integer [] generatedArray = list.toArray(new Integer[0]);
        return generatedArray;
    }

    public static Integer returnFindElement (Integer [] searchArray) {
        Integer find = searchArray [3400];
        return find;
    }

    public static Integer linearSearch(Integer arr[], Integer elementToSearch) {

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    public static Integer binarySearch(Integer arr[], Integer elementToSearch) {

        Integer firstIndex = 0;
        Integer lastIndex = arr.length - 1;

        while(firstIndex <= lastIndex) {
            Integer middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }
}
