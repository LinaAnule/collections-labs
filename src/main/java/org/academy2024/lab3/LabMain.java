package org.academy2024.lab3;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;
import org.academy2024.lab2.StatementLine;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void exercise_3_1_printTopTransactions() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        int howManyBiggestAmounts = 4;

        //TODO: Find the biggest transactions


        Set<Transaction> transactions1 = transactions.stream().sorted(Comparator.comparing(Transaction::amount).reversed()).limit(3)
                .collect(Collectors.toSet());

        transactions.stream().sorted(Comparator.comparing(Transaction::date))
                .forEach(t -> LinePrinter.print(transactions1.contains(t) ? Color.RED : Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_3_1_printTopTransactions();

    }
}
