package lr2;

interface BankingOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class BankAccount implements BankingOperations {
    private double balance;
    public BankAccount() {
        this.balance = 0.0;
    }
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Депозит ₽" + amount + " успешно. Новый баланс: ₽" + balance);
        } else {
            System.out.println("Баланс должен быть больше 0.");
        }
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Списание ₽" + amount + " успешно. Новый баланс: ₽" + balance);
        } else {
            System.out.println("Недостаточно средств или сумма вывода должна быть больше нуля.");
        }
    }
    @Override
    public double getBalance() {
        return balance;
    }
}
public class Work7 {
    public static void main(String[] args) {
        BankingOperations account = new BankAccount();

        account.deposit(1000); // Депозит на 1000
        account.withdraw(500); // Снятие 500
        account.deposit(200);  // Депозит на 200

        System.out.println("Текущий баланс: ₽" + account.getBalance());
    }
}
