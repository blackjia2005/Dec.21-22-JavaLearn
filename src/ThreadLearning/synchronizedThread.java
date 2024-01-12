package ThreadLearning; /**
 * Dec.21
 * 64线程同步和安全性
 */

public class synchronizedThread {

    public static void main(String[] args) {

        Account blake = new Account(80,"Blake");
        Thread t1 = new withDrawMoney(blake,50);
        Thread t2 = new withDrawMoney(blake,50);

        Account Bella = new Account(100,"Bella");
        Thread t3 = new withDrawMoney(Bella, 50);
        Thread t4 = new withDrawMoney(Bella, 30);
        Thread t5 = new withDrawMoney(Bella, 30);

        t1.start();
        t2.start();
        t3.start();              // 不同对象不干扰
        t4.start();
        t5.start();

        try {
            t5.join();          // 让主进程等待t5进程结束再结束。否则主进程早就结束了
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("主进程结束！");
    }



}

class Account{
    int money;
    String accountName;

    public Account(int money, String accountName) {
        this.money = money;
        this.accountName = accountName;
    }

    public void draw(int money){
        this.money -= money;
    }
}

class withDrawMoney extends Thread{

    Account account;
    int money;

    withDrawMoney(Account account,int money){
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (account){                        // 用synchronized 保证对象的使用
            System.out.println(account.accountName+"正在取款"+money+"元"); //保证该对象调用结束再调用
            if (account.money<money){
                System.out.println("余额不足，卡中余额"+account.money+"元");
                return ;}
            try {
                Thread.sleep(2000);            // 由于这个导致的可能过度取钱的问题
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.account.draw(money);

        }
        System.out.println("取款成功，剩余余额"+account.money);
    }
}