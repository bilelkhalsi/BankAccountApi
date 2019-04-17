package bank;

import bank.domain.Account;
import bank.domain.AccountImpl;
import bank.domain.Amount;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Main {

    public static void main(String[] args) {
        Account account = new AccountImpl();
        account.deposit(new Amount(1000));
        account.deposit(new Amount(2000));

    }
}
