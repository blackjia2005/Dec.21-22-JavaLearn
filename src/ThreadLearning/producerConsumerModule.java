package ThreadLearning; /**
 * Dec.21
 * 65生产者消费者模式
 * !!!没理解!!!
 */

public class producerConsumerModule {

    public static void main(String[] args) {
        SyncStack carStack = new SyncStack();

        producer Ford = new producer(carStack);
        consumer Blake = new consumer(carStack);

        Ford.start();
//        Blake.start();

    }
}

class producer extends Thread{
    SyncStack ss;

    public producer(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i<11 ; i++){
            System.out.println("生产car"+i);
            this.ss.push(new car(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class consumer extends Thread{
    SyncStack ss;

    public consumer(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            car my_car = this.ss.pop();
            System.out.println("消费car"+my_car.id);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SyncStack{
    int index = 0;
    car[] cars = new car[10];

    public synchronized void push(car my_car){
        while(index == cars.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        cars[index] = my_car;
        index ++;
        this.notify();
    }

    public synchronized car pop(){
        while(index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        index --;
        this.notify();
        return cars[index];
    }
}

class car{
    int id;

    public car(int id) {
        this.id = id;
    }
}