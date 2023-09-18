public class TrafficLightTest {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // 线程1控制红灯
        Thread thread1 = new Thread(() -> {
            trafficLight.turnRed();
            try {
                Thread.sleep(5000); // 红灯持续5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            trafficLight.switchLight(); // 切换到绿灯
        });

        // 线程2控制绿灯
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000); // 等待2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            trafficLight.turnGreen();
            try {
                Thread.sleep(3000); // 绿灯持续3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            trafficLight.switchLight(); // 切换到红灯
        });

        thread1.start();
        thread2.start();
    }
}
