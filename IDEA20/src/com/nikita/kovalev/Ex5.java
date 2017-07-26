package com.nikita.kovalev;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by nikit on 26.07.2017.
 * The program welcomes the user in 3 languages
 */
public class Ex5 {
    public static void main(String... args) {
        String s1 = "en";
        String s2 = "EN";
        try {
            if (!args[0].isEmpty() && !args[1].isEmpty()) {
                s1 = args[0];
                s2 = args[1];
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        Locale l = new Locale(s1, s2);
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", l);
        System.out.println(rb.getString("greetings"));
    }
}
