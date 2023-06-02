package task1;

import java.util.ArrayList;
import java.util.List;

public class AsynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final int INITIAL_BALANCE = 10000;

    public static void main(String[] args) throws InterruptedException {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        int transactionLimit = 10000;
        List<TransferThread> threads = new ArrayList<>();

        for (i = 0; i < NACCOUNTS; i++) {
            TransferThread t = new TransferThread(b, i, INITIAL_BALANCE, transactionLimit);

            t.setPriority(Thread.NORM_PRIORITY + i % 2);
            t.start();
            threads.add(t);
        }

        for (TransferThread t : threads) {
            t.join();
        }
    }
}

