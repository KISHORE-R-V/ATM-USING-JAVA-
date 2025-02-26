import java.util.Scanner;

public class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit Successful. New Balance: " + balance);
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful. New Balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("Pin Changed Successfully");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000, 1234);

        System.out.print("Enter The Pin: ");
        int pin = scanner.nextInt();

        if (atm.validatePin(pin)) {
            int option = 0;
            while (option != 5) {
                atm.displayMenu();
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Balance: " + atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter Amount: ");
                        int depositAmount = scanner.nextInt();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter Amount: ");
                        int withdrawAmount = scanner.nextInt();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter New Pin: ");
                        int newPin = scanner.nextInt();
                        atm.changePin(newPin);
                        break;
                    case 5:
                        System.out.println("Thank You");
                        break;
                    default:
                        System.out.println("Invalid Option! Try Again.");
                }
            }
        } else {
            System.out.println("You Have Entered an Invalid Pin");
        }
        scanner.close();
    }
}
