package bank.domain;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    public void withdrawal(Amount value) throws AmountNotAvailable {
        Objects.requireNonNull(value, "amount must be not null!");
        if (Amount.compareAmount.compare(balance, value) < 0) {
            throw new AmountNotAvailable("Account balance insufficient!");
        }
        Transaction transaction = new Transaction(value.negative(), LocalDate.now());
        this.balance = transaction.executeTransaction(balance);
        statement.addStatementLine(transaction, this.balance);
    }


    @Override
    public String report() {
        return statement.toString();
    }

    @Override
    public Amount currentBalance() {
        return balance;
    }
}
