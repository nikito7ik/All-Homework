package com.nikita.kovalev.Service;

import com.nikita.kovalev.ATM;

import static com.nikita.kovalev.Scanner.Scan;

/**
 * This class checks correct pin cod for service
 */
public class Service_PinCod {

    int pin = 1234;

    public void Service_PinCod() {
        System.out.println("Please, enter the pin cod");
        int i = 1;
        while (!User_PinCorrect()) {
            i++;
            if (i > 3) {
                System.out.println("You are not a service, you entered the wrong pin cod for 3 times, do not break the law!");
                return;
            }
        }
        ATM atm = new ATM();
        atm.ATM_ServiceMenu();;
    }

    public boolean User_PinCorrect() {
        int x = Scan();
            if (x == pin) {
                return true;
            }
        System.out.println("Wrong pin");
        return false;
    }
}
