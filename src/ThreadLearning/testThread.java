package ThreadLearning;

public class testThread extends Thread{

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            System.out.println(this.getName()+":"+i);
        }
    }


    public static void main(String[] args) {

        testThread t1 = new testThread();
        testThread t2 = new testThread();
        testThread t3 = new testThread();

        t1.start();
        t2.start();
        t3.start();


    }

}
