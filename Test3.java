// Create a class Account with attributes:

// accountNumber (int)
// accountHolder (String)
// balance (double)
// Create a method displayAccountInfo in the Account class to display the account details.
class Account implements Transaction {
    int accountNumber;
    String accountHolder;
    double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("---*---*---*---*---*---*---*---*---*---*");
        System.out.println("Account Number is : " + accountNumber);
        System.out.println("Account Holder Name is : " + accountHolder);
        System.out.println("Account Balance is : " + balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds. Withdrawal not allowed.");
        }
    }
}

// Create a subclass SavingsAccount that extends Account with an additional attribute:
// interestRate (double)
// Override the displayAccountInfo method in the SavingsAccount class to include the interest rate.
class SavingsAccount extends Account implements Transaction{
    double interestRate;
    public SavingsAccount(int accountNumber, String accountHolder, double balance ,double interestRate ) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountInfo(){
        super.displayAccountInfo();
        System.out.println("IntrestRate is :" + interestRate + " %");
    }

    @Override
    public void deposit(double amount) {
        balance = balance  + amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds. Withdrawal not allowed.");
        }
    }    
}

// Create an interface Transaction with methods:
// deposit(double amount)
// withdraw(double amount)
interface Transaction{
    void deposit(double amount);
    void withdraw(double amount);
}
// Implement the Transaction interface in both Account and SavingsAccount classes.

// Test your implementation by creating instances of both Account and SavingsAccount, perform transactions (deposits and withdrawals), and display the account information.

public class Test3 {
    public static void main(String[] args) {
        Account acc1 = new Account(2272, "Bhavik", 25000);
        SavingsAccount acc2 = new SavingsAccount(1372, "Akshay", 300000, 7);

        acc1.displayAccountInfo();

        acc1.withdraw(29000);
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
    }
}
