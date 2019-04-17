package bank.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account sut;

    @BeforeEach
    void setup() {
        sut = new AccountImpl();
    }

    @Test
    void should_save_money_in_account() {
        sut.deposit(new Amount(500));
        assertEquals(sut.currentBalance().getValue(), 500);
    }

    @Test
    void should_retrieve_money_from_the_account() throws AmountNotAvailable {
        sut.deposit(new Amount(500));
        sut.withdrawal(new Amount(500));
        assertEquals(sut.currentBalance().getValue(), 0);
    }


}