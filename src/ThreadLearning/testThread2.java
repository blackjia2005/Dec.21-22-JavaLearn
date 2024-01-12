package ThreadLearning;

/**
 * Dec.21
 * 62JAVA线程的两种实现方式
 * 63线程的多种状态-优先级
 */

public class testThread2 {

    public static void main(String[] args) {

        runnableInterface();

    }

    // 方式1，runnable interface接口实现类
    public static void runnableInterface(){

        Thread t1 = new Thread(new runnableThread(),"t1");
        Thread t2 = new Thread(new runnableThread(),"t2");
        Thread t3 = new Thread(new runnableThread(),"t3");

        t1.setPriority(1);             //设置优先级，默认为5
        t2.setPriority(3);
        t3.setPriority(10);

        t1.start();
        t2.start();
        try {
            t2.join();                       //主程序会等到t2执行完再执行
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();

        System.out.println(t1.isAlive());
        System.out.println("主线程结束！");
    }

    // 方式2，用lambda匿名内部类(本质相同） -- 可以缩写 Thread(()->{...})
    public static void lambdaExpression(){
        new Thread(()-> {
            for(int i = 0; i<10; i++)
               System.out.println(i);
        });
    }

}

class runnableThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(100);   //sleep等待 -> 就续状态
                //Thread.yield();            // 让出 -> 就绪状态
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}