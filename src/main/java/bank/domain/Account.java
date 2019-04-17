package bank.domain;

public interface Account {

    /**
     * Deposit an amount in the account.
     * @param amount amount
     */
    void deposit(Amount amount);

    /**
     * Withdrawal an amount from the account.
     * @param amount amount
     */
    void withdrawal(Amount amount);

    /**
     * Return account balance.
     * @return balance.
     */
    Amount currentBalance();
}

