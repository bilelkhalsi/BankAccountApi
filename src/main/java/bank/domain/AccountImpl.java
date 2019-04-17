package bank.domain;

import java.time.LocalDate;

public class AccountImpl implements Account {

    private Statement statement;

    private Amount balance = new Amount(0);

    public AccountImpl() {
        this.statement = new Statement();
    }

    @Override
    public void deposit(Amount value) {
        Transaction transaction = new Transaction(value, LocalDate.now());
        this.balance = transaction.executeTransaction(balance);
        statement.addStatementLine(transaction, this.balance);
    }


    @Override
    public void withdrawal(Amount value) {
        Transaction transaction = new Transaction(value.negative(), LocalDate.now());
        this.balance = transaction.executeTransaction(balance);
        statement.addStatementLine(transaction, this.balance);
    }


    @Override
    public Amount currentBalance() {
        return balance;
    }
}
