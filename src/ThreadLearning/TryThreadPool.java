package ThreadLearning; /**
 * Dec.21
 * 66线程池
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TryThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(50));

        for (int i =0; i<20 ;i++){
            myTask my_task = new myTask(i);
            executor.execute(my_task);

            System.out.println("目前线程池大小："+executor.getPoolSize()+
                    "目前正在排队的Task数量："+executor.getQueue().size()+
                    "已经完成的Task数："+executor.getCompletedTaskCount());
        }

        executor.shutdown();

    }
}



class myTask implements Runnable {
    private int ID;

    public myTask(int id){
        this.ID = id;
    }

    @Override
    public void run() {
        System.out.println("开始执行 task"+this.ID);
        try {
            Thread.sleep((long) Math.round(Math.random()*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("task"+this.ID+"执行完毕");
    }
}