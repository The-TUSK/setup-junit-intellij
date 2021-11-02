import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAcount class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 500 Successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance()); //Check expected

    }

    @Test
    @DisplayName("Withraw will become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance()); //Check unexpected
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTrue(bankAccount.isActive()); //Check if true
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.setHolderName("Mark");
        assertNotNull(bankAccount.getHolderName());
    }
    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutException(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(200));
        assertEquals(0.33, 1/3, "Oops, not the same");
    }

}
