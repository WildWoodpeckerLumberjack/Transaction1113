import java.util.Random;
import java.util.TreeMap;

public class Bank {
    private TreeMap<String, Account> accounts;
    private final Random random = new Random();
    private long fraudAmount = 50000;
    private int accountsNumber = 0;

    public Bank(int accountsNumber) {
        this.accounts = new TreeMap<String, Account>();
        this.accountsNumber = accountsNumber;
        for (int i = 0; i < accountsNumber; i++) {
            this.accounts.put(Integer.toString(i), new Account(newAccountNum(), (long) (Math.random() * 1000000)));
        }
    }

    public TreeMap<String, Account> getAccounts() {
        return accounts;
    }


    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции, //вынес значение максимальной суммы до проверки в отдельную переменную
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (getBalance(fromAccountNum) > amount || !isBlocked(fromAccountNum) || !isBlocked(toAccountNum)) {
            setBalance(fromAccountNum, getBalance(fromAccountNum) - amount);
            setBalance(toAccountNum, getBalance(toAccountNum) + amount);
            if (amount > fraudAmount) {
                try {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        blockAccount(fromAccountNum);
                        blockAccount(toAccountNum);
                    };
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        System.out.println(accountNum);
        getAccounts().values().
        System.out.println(getAccounts().get(accountNum).getMoney());
        return getAccounts().get(accountNum).getMoney();
    }

    /**
     * Ну, где getBalance, там и setBalance :)
     */
    public void setBalance(String accountNum, long amount) {
        getAccounts().get(accountNum).setMoney(amount);
    }

    public boolean isBlocked(String accountNum) {
        return getAccounts().get(accountNum).isBlocked();
    }

    public String newAccountNum() {
        String accNumber = "";
        do {
            accNumber = Double.toString(Math.random()).replace("0.", "");
        } while (accNumber.length() != 16);
        return accNumber;
    }

    public void blockAccount(String accountNum) {
        getAccounts().get(accountNum).setBlocked(true);
    }
}
