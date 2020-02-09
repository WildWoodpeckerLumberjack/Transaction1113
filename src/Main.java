public class Main
{
    public static void main(String[] args) {
        Bank bank = new Bank(10);
        bank.getAccounts().entrySet().forEach(acc -> System.out.println(acc.getKey() + " " + acc.getValue().getAccNumber() + " " + acc.getValue().getMoney()));

        System.out.println();
        bank.getAccounts().values().forEach(account -> {
            System.out.println(account.getAccNumber() + " " + account.getMoney());
        });

        System.out.println();
        System.out.println(bank.getAccounts().get("0").getAccNumber() + " " + bank.getAccounts().get("0").getMoney());
        System.out.println();

        String testAccNum = bank.getAccounts().get("0").getAccNumber();
        System.out.println(testAccNum + " " + bank.findAccByAccNumber(testAccNum).getMoney());
        String testAccNum2 = bank.getAccounts().get("1").getAccNumber();
        System.out.println(testAccNum2 + " " + bank.findAccByAccNumber(testAccNum2).getMoney());
        System.out.println();
        bank.transfer(testAccNum, testAccNum2, 1000);
        System.out.println();
        System.out.println(testAccNum + " " + bank.findAccByAccNumber(testAccNum).getMoney());
        System.out.println(testAccNum2 + " " + bank.findAccByAccNumber(testAccNum2).getMoney());

/*

        bank.transfer(bank.getAccounts().get("0").getAccNumber(), bank.getAccounts().get("1").getAccNumber(), 1000);
        System.out.println(bank.getAccounts().get("0").getAccNumber() + " " + bank.getAccounts().get("0").getMoney());
        System.out.println(bank.getAccounts().get("1").getAccNumber() + " " + bank.getAccounts().get("1").getMoney());
        System.out.println();
*/

    }
}
