package com.nikita.kovalev.User;

import com.nikita.kovalev.Service.Service;

import static com.nikita.kovalev.Scanner.Scan;

/**
 * ATM operation and withdrawal of money to the user
 */
public class User extends Service {

    private int moneyCash;
    private int money20;
    private int money50;
    private int money100;
    private int money;

    public void User_TakeMoney() {
        System.out.println("How much money do you want to withdraw?");
        try {
            money = Scan();
            ATM_Withdraw();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ATM_Withdraw() {
        if (money > Service_HowMuchMoneyInATM()) {
            System.out.println("There is not enough money in the ATM");
        } else {
            moneyCash = money;

            money100 = moneyCash / 100;
            if (money100 > cash100) {
                money100 = cash100;
            }
            moneyCash -= money100 * 100;

            money50 = moneyCash / 50;
            if (money50 > cash50) {
                money50 = cash50;
            }
            moneyCash -= money50 * 50;

            money20 = moneyCash / 20;
            moneyCash -= money20 * 20;

            User_Withdraw();
        }
    }

    public void User_Withdraw() {
        if (moneyCash > 0) {
            System.out.println("The ATM cannot perform this operation. Please specify a different amount of money");
        } else {
            cash100 -= money100;
            cash50 -= money50;
            cash20 -= money20;
            System.out.println("Take your " + money + " rub.");
            System.out.println("Issued banknotes with par value 20: " + money20);
            System.out.println("Issued banknotes with par value 50: " + money50);
            System.out.println("Issued banknotes with par value 100: " + money100);
        }
    }
}
