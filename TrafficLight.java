import java.util.concurrent.Semaphore;

public class TrafficLight {
    private Semaphore redSemaphore;
    private Semaphore greenSemaphore;

    public TrafficLight() {
        redSemaphore = new Semaphore(1); // 初始状态为红灯
        greenSemaphore = new Semaphore(0);
    }

    public void turnRed() {
        try {
            redSemaphore.acquire(); // 获取红灯信号量
            System.out.println("红灯亮起");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void turnGreen() {
        try {
            greenSemaphore.acquire(); // 获取绿灯信号量
            System.out.println("绿灯亮起");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchLight() {
        try {
            redSemaphore.release(); // 释放红灯信号量
            greenSemaphore.release(); // 释放绿灯信号量
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
