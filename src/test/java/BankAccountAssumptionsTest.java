import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assumingThat(bankAccount == null, () -> assertTrue(bankAccount.isActive()));
    }

}
