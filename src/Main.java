public class Main
{
    public static void main(String[] args) {
        Bank bank = new Bank(10);
        bank.getAccounts().entrySet().forEach(acc -> System.out.println(acc.getKey() + " " + acc.getValue().getAccNumber() + " " + acc.getValue().getMoney()));

        System.out.println();
        System.out.println(bank.getAccounts().get("0").getAccNumber() + " " + bank.getAccounts().get("0").getMoney());
        System.out.println(bank.getAccounts().get("1").getAccNumber() + " " + bank.getAccounts().get("1").getMoney());
        System.out.println();

        System.out.println(bank.getBalance(bank.getAccounts().get("0").getAccNumber()));
        System.out.println(bank.getBalance(bank.getAccounts().get("1").getAccNumber()));

        bank.transfer(bank.getAccounts().get("0").getAccNumber(), bank.getAccounts().get("1").getAccNumber(), 1000);
        System.out.println(bank.getAccounts().get("0").getAccNumber() + " " + bank.getAccounts().get("0").getMoney());
        System.out.println(bank.getAccounts().get("1").getAccNumber() + " " + bank.getAccounts().get("1").getMoney());
        System.out.println();

    }
}
