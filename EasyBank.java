package com.programming2;

@Component
public class EasyBank {

    @Value("${pin:6789}") // fallback default value if not in properties
    private int pinCode;

    @Value("${balance:1000}")
    private int balance;

    private int tempPin;

    public int getPinCode() {
        return pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public int getTempPin() {
        return tempPin;
    }

    public void setTempPin(int tempPin) {
        this.tempPin = tempPin;
    }

    public void doWithdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("You have successfully withdrawn " + amount);
        }
    }

    public void doDeposit(int amount) {
        balance += amount;
        System.out.println("You have successfully deposited " + amount);
    }

    public void doPinChange(int oldPin, int pin) throws Exception {
        if (pinCode == oldPin) {
            pinCode = pin;
        } else throw new Exception("Invalid Pin");
    }

    public void showBalance() {
        System.out.println("your balance is " + balance);
    }
}