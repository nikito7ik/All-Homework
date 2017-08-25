package com.nikita.kovalev.User;

import com.nikita.kovalev.User.User;

import static com.nikita.kovalev.Scanner.Scan;

/**
 * This class checks correct pin cod for users
 */
public class User_PinCod {

    int[] pin = {1111, 5824, 2456, 8245, 2846, 4296, 4267};

    public void User_PinCod() {
        System.out.println("Please, enter the pin cod");
        int i = 1;
        while (!User_PinCorrect()) {
            i++;
            if (i > 3) {
                System.out.println("You entered the wrong pin cod for 3 times!");
                return;
            }
        }
        User user = new User();
        user.User_TakeMoney();
    }

    public boolean User_PinCorrect() {
        int x = Scan();
        for (int i = 0; i < pin.length; i++) {
            if (x == pin[i]) {
                return true;
            }
        }
        System.out.println("Wrong pin");
        return false;
    }
}
