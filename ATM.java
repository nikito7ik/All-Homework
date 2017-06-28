package com.nikita.kovalev;

import static com.nikita.kovalev.Scanner.Scan;

/**
 * Main class
 */
public class ATM {

    static int i;

    public static void main(final String... args) {
        ATM_Service();
        while (i != 3) {
            System.out.println("Press 1 if you are user. Press 2 if you are service. Press 3 to turn ATM off (ONLY for service)");
            Check_User_or_Service();
        }
    }

    public static void ATM_Service() {
        Service ATM = new Service();
        ATM.Service_PutMoney();
        ATM.Service_HowMuchMoneyInATM_Print();
    }

    public static void Check_User_or_Service() {
        i = Scan();
        if (i == 1) {
            User user = new User();
            user.User_TakeMoney();
        } else if (i == 2) {
            ATM_Service();
        } else if (i != 3) {
            System.out.println("Please, press 1 or 2!");
        }
    }
}
