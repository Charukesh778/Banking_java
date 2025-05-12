import java.util.*;

class Account {
    int id;
    String name;
    double balance;

    Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    void deposit(double amount) {
        balance += amount;
    }

    boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Balance: ₹" + balance);
    }
}

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create 2. Deposit 3. Withdraw 4. View 5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> viewAccounts();
                case 5 -> System.exit(0);
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        accounts.put(id, new Account(id, name));
        System.out.println("Account created.");
    }

    static void depositMoney() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        if (accounts.containsKey(id)) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            accounts.get(id).deposit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        if (accounts.containsKey(id)) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            if (!accounts.get(id).withdraw(amt)) {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    static void viewAccounts() {
        for (Account acc : accounts.values()) {
            acc.display();
        }
    }
}
