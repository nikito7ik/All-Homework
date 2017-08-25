package com.nikita.kovalev.Service;

import java.util.Scanner;

import static com.nikita.kovalev.Scanner.Scan;

/**
 * Class for servicing the ATM
 */
public class Service {

    public int cash20;
    public int cash50;
    public int cash100;

    public void Service_PutMoney() {
        System.out.println("How much banknotes load into an ATM of nominal value 20?"); cash20 += Scan();
        System.out.println("How much banknotes load into an ATM of nominal value 50?"); cash50 += Scan();
        System.out.println("How much banknotes load into an ATM of nominal value 100?"); cash100 += Scan();
    }

    public int Service_HowMuchMoneyInATM() {
        return cash20 * 20 + cash50 * 50 + cash100 * 100;
    }

    public void Service_HowMuchMoneyInATM_Print() {
        System.out.println("Denominations in nominal value 20: " + cash20);
        System.out.println("Denominations in nominal value 50: " + cash50);
        System.out.println("Denominations in nominal value 100: " + cash100);
        System.out.println("The ATM is loaded: " + Service_HowMuchMoneyInATM() + " rub.");
    }
}
