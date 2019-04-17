package bank.domain;

import java.util.Objects;

public class StatementLine {

    private Transaction transaction;
    private Amount currentBalance;

    public StatementLine(Transaction transaction, Amount currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return String.join(" | ", this.transaction.toString(), currentBalance.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StatementLine)) {
            return false;
        }
        return Objects.equals(transaction, ((StatementLine) obj).transaction)
                && Objects.equals(currentBalance, ((StatementLine) obj).currentBalance);
    }
}
