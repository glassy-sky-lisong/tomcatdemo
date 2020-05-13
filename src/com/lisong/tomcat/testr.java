package com.lisong.tomcat;

/**
 * @author lenovo
 * @package com.lisong.tomcat
 * @date 2020/5/13 17:45
 * @Description
 */
public class testr {
    private volatile boolean isfinish = false;

    private void run() {
        try {
            isfinish = true;
            while (true) {
                System.out.println("isfinish = "+isfinish);
                if (isfinish) {

                    System.out.println("stop ....");
                    break;
                }
                System.out.println("runing...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        run();
    }

    public void stop() {
        isfinish = false;
    }



    public static void main(String[] args) {
        testr testr = new testr();
        testr.start();
        testr.stop();
    }
}
