package bank.domain;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statement {

    private final static String HEADERS = Stream.of("date", "credit", "debit", "balance")
            .map(String::toUpperCase)
            .map(h -> Strings.padEnd(h, 15, ' '))
            .collect(Collectors.joining(" | "));

    private List<StatementLine> statementLines = new ArrayList<>();

    public void addStatementLine(Transaction transaction, Amount currentBalance) {
        statementLines.add(0, new StatementLine(transaction, currentBalance));
    }

    @Override
    public String toString() {
        return Stream.concat(Stream.of(HEADERS), statementLines.stream()).map(Object::toString).collect(Collectors.joining(" \n"));
    }


}
