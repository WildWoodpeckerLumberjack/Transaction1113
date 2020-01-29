import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts;

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public Bank() {
        this.accounts = new HashMap<String, Account>();
        for (int i = 0; i < 10000; i++) {
            String accNumber = Double.toString(Math.random()).replace("0.", "");
            this.accounts.put(accNumber, new Account(accNumber, (long) (Math.random() * 100000)));
        }
    }

    private final Random random = new Random();


    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount)
    {
        
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        //accounts.entrySet().
        return 0;
    }
}
