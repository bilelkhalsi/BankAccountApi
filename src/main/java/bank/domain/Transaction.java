package bank.domain;

import com.google.common.base.Strings;

import java.time.LocalDate;
import java.util.Objects;


public class Transaction {

    private Amount value;
    private LocalDate date;

    public Transaction(Amount value, LocalDate date) {
        this.value = Objects.requireNonNull(value);
        this.date = Objects.requireNonNullElse(date, LocalDate.now());
    }

    public Amount executeTransaction(Amount currentBalance) {
        return currentBalance.plus(value);
    }

    @Override
    public String toString() {
        return String.join(" | ",
                Strings.padEnd(date.toString(), 15, ' '),
                Strings.padEnd(value.toString(), 15, ' ')
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Transaction)) {
            return false;
        }
        return Objects.equals(date, ((Transaction) obj).date)
                && Objects.equals(value, ((Transaction) obj).value);
    }


}
