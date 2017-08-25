package com.nikita.kovalev;

import com.nikita.kovalev.Service.Service;
import com.nikita.kovalev.Service.Service_PinCod;
import com.nikita.kovalev.User.User_PinCod;

import java.io.IOException;

import static com.nikita.kovalev.Scanner.Scan;

/**
 * ATM class is responsible for all processes
 */
public class ATM {

    static int i;

    public static void main(final String... args) {
        while (i != 3) {
            System.out.println("Press 1 if you are user. Press 2 if you are service. Press 3 to turn ATM off (ONLY for service)");
            try {
                Check_User_or_Service();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void ATM_ServiceMenu() {
        Service ATM = new Service();
        int b = 0;
        while (b != 3) {
            System.out.println("SERVICE MENU: Press 1 (Put money to ATM) or 2 (Amount of banknotes) or 3 (Exit to main menu)");
            b = Scan();
            if (b == 1) {
                ATM.Service_PutMoney();
            } else if (b == 2) {
                ATM.Service_HowMuchMoneyInATM_Print();
            } else if (b == 3) {
            } else {
                System.out.println("Please press 1, 2 or 3");
            }
        }
    }

    public static void Check_User_or_Service() {
        i = Scan();
        if (i == 1) {
            try {
                User_PinCod pinCod = new User_PinCod();
                pinCod.User_PinCod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 2) {
            try {
                Service_PinCod service_pinCod = new Service_PinCod();
                service_pinCod.Service_PinCod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i != 3) {
            System.out.println("Please, press 1 or 2!");
        }
    }
}
