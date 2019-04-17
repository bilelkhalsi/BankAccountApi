package bank.domain;

public class AmountNotAvailable extends Exception {

    public AmountNotAvailable(String msg) {
        super(msg);
    }

    public AmountNotAvailable(Throwable cause) {
        super(cause);
    }

    public AmountNotAvailable(String msg, Throwable cause) {
        super(msg, cause);
    }
}
