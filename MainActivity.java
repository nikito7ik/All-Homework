package com.nikita.kovalev;

import java.util.*;

/**
 * Created by nikit on 01.07.2017. This class create the list which consists of 0-20 marks.
 * After this class delete bad marks, sort marks, choose the highest mark.
 */
public class MainActivity {

    public static void main(String[] args) {

        Random r = new Random();
        List<Integer> arrayList = new ArrayList();
        int arraySize = r.nextInt(20);

        for (int i = 0; i < arraySize; i++) {
            arrayList.add(new Integer(r.nextInt(11)));
        }
        System.out.println("All marks: " + arrayList);

        Delete_BadMarks(arrayList);
        Delete_RepeatedMarks(arrayList);
        TheHighestMark(arrayList);
    }

    //Delete bad marks (<3)
    public static void Delete_BadMarks(List<Integer> _arrayList) {
        for (int i = _arrayList.size() - 1; i >= 0; i--) {
            int mark = new Integer(_arrayList.get(i).toString());
            if (mark < 3) {
                _arrayList.remove(i);
            }
        }
        System.out.println("Only good marks: " + _arrayList);
    }

    //Delete repeated marks and sort them (the lowest - the highest)
    public static void Delete_RepeatedMarks(List<Integer> _arrayList) {
        List<Integer> result = new ArrayList(new HashSet(_arrayList));
        Collections.sort(result);
        System.out.println("Sorted marks without repeat: " + result);
    }

    //Choose the highest mark
    public static void TheHighestMark(List<Integer> _arrayList) {
        int theHighestMark = 0;
        Iterator<Integer> iterator = _arrayList.iterator();

        while (iterator.hasNext()) {
            int nextMark = iterator.next();
            if (nextMark > theHighestMark) {
                theHighestMark = nextMark;
            }
        }
        System.out.println("The highest mark is: " + theHighestMark);
    }
}
