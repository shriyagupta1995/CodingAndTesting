import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance());
    }
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void testOverdraftNotAllowed() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }
    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }
}