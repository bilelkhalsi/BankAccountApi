package bank.domain;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Objects;

public class Amount {
    public static final Comparator<Amount> compareAmount = Comparator.comparingInt(Amount::getValue);
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