public class Main
{
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.getAccounts().entrySet().forEach(acc -> System.out.println(acc.getKey() + " " + acc.getValue().getAccNumber() + " " + acc.getValue().getMoney()));
    }
}
