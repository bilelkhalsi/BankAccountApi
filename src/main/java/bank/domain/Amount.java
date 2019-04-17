package bank.domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class Amount {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    private int value;

    public Amount(int value) {
        this.value = value;
    }

    public Amount plus(Amount otherAmount) {
        return new Amount(this.value + otherAmount.value);
    }

    public Amount negative() {
        return new Amount(-value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return decimalFormat.format(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Amount)) {
            return false;
        }
        return Objects.equals(this.value, ((Amount) obj).value);
    }
}