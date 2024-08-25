package setup;

public class Util {

    public static void pauseExecutionForSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
