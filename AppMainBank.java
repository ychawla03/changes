package com.programming2.class2;

package com.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AppMainBank implements CommandLineRunner {

    @Autowired
    private EasyBank easyBank;

    public static void main(String[] args) {
        SpringApplication.run(AppMainBank.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int pin = 0;
        int amnt = 0;
        do {
            System.out.println("\nSelect option \n 1.Deposit\n 2.Withdraw\n 3.Change Pin\n 4.Show Balance\n 5.Exit");
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1: {
                        System.out.println("Enter amount to be Deposited");
                        amnt = sc.nextInt();
                        System.out.println("Enter pin");
                        pin = sc.nextInt();
                        easyBank.setTempPin(pin);
                        if (easyBank.getPinCode() == pin) {
                            easyBank.doDeposit(amnt);
                        } else {
                            System.out.println("invalid pin");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Enter amount to withdraw");
                        amnt = sc.nextInt();
                        System.out.println("Enter pin");
                        pin = sc.nextInt();
                        easyBank.setTempPin(pin);
                        if (easyBank.getPinCode() == pin) {
                            easyBank.doWithdraw(amnt);
                        } else {
                            System.out.println("invalid pin");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter old pin");
                        int oldPin = sc.nextInt();
                        System.out.println("Enter new pin");
                        int newPin = sc.nextInt();
                        easyBank.doPinChange(oldPin, newPin);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter pin");
                        pin = sc.nextInt();
                        easyBank.setTempPin(pin);
                        easyBank.showBalance();
                        break;
                    }
                    case 5: {
                        System.out.println("Exiting...");
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Unexpected value: " + choice);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
    }
}
