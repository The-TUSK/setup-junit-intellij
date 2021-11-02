import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(BankAccount bankAccount) {
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance()); //Check expected
    }
    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit2(BankAccount bankAccount) {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance()); //Check expected
    }
    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit3(BankAccount bankAccount) {
        try{
            Thread.sleep(1200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance()); //Check expected
    }
}
