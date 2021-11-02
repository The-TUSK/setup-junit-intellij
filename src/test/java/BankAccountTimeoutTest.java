import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    //What is the difference between the timeout annotation and assertTimeout assertion?
    //Answer: The timeout annotation is timing the full method and the assertTimeout
    // only the execution of the assertion.

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void tesetDepositTimeoutAssertion(BankAccount bankAccount){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(10);
        });
    }
}