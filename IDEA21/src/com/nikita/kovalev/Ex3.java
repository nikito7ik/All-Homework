package com.nikita.kovalev;

/**
 * Created by nikit on 26.07.2017.
 * This class replaces tags in the text
 */
public class Ex3 {

    public static void main(final String... args) {

        String s = "<p2465246> This text does nothing <p p2-=2ot2-94tj2 >. It just sits here <p p=135 > ";
        System.out.println("Text: " + s);

        String s2 = s.replaceAll("<p[^>]*>","<p>");
        System.out.println("Modified text: " + s2);
    }

}
