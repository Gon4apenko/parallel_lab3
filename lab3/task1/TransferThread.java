package task1;

class TransferThread extends Thread {
    private Bank bank;
    private int fromAccount;
    private int maxAmount;
    private static final int REPS = 1000;
    private int transactionLimit;

    public TransferThread(Bank b, int from, int max, int limit) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
        transactionLimit = limit;
    }

    @Override
    public void run() {
        int transactionCount = 0;
        while (transactionCount < transactionLimit && !isInterrupted()) {
            for (int i = 0; i < REPS; i++) {
                int toAccount = (int) (bank.size() * Math.random());
                int amount = (int) (maxAmount * Math.random() / REPS);
                bank.transfer(fromAccount, toAccount, amount);
                transactionCount++;


                if (transactionCount >= transactionLimit) {
                    break;
                }
            }
        }
    }
}
