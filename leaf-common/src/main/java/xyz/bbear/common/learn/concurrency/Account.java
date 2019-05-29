package xyz.bbear.common.learn.concurrency;

/**
 * Account.
 *
 * @author xiongliu wu 2019-05-13 17:40
 */
public class Account {

  private double balance;

  public synchronized void add(double balance) {
    this.balance += balance;
  }

  public double getBalance() {
    return this.balance;
  }

  public static void main(String[] args) {
    Account account = new Account();
    Thread t1 =
        new Thread(
            () -> {
              try {
                Thread.sleep(5000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              account.add(12);
              System.out.println(account.getBalance());
            });

    Thread t2 =
        new Thread(
            () -> {
              account.add(13);
              System.out.println(account.getBalance());
            });

    t1.start();
    t2.start();
  }
}
