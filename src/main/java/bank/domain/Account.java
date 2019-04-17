package bank.domain;

public interface Account {

    /**
     * Deposit an amount in the account.
     * @param amount amount
     */
    void deposit(Amount amount);

    /**
     * Return account balance.
     * @return balance.
     */
    Amount currentBalance();
}

