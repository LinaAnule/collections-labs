package org.academy2024.lab4;

import org.academy2024.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void lab4_1_namesOfAccountHolders() {
        //covert Collection AccountHolder to map map ID to name an then provide Statement;

        List<Transaction> transactions = DataHelper.loadTransactions();
        List<AccountHolder> accountHolders = DataHelper.loadAccountHolders();
        Map<String, AccountHolder> accountHolderMap = new HashMap<>();
        accountHolders.forEach((t) -> {
            intoMap(accountHolderMap, t);
        });

        //TODO: Map ids in transactions to account holders and create statement lines
        //then print the statement lines
        transactions.stream()
                .map(t -> new StatementLine(accountHolderMap.get(t.accountId()).name(), t.accountId(), t.date(), t.amount()))
                .forEach(t -> LinePrinter.print(t.toString()));
        LinePrinter.resetColor();

    }

    void intoMap(Map<String, AccountHolder> m, AccountHolder a) {
        m.put(a.accountId(), a);
    }

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.lab4_1_namesOfAccountHolders();

    }
}
