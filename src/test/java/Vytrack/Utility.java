package Vytrack;

public class Utility {

    public static void waitTime (int millis) {

        try {
            Thread.sleep(millis);
        }catch (Exception e) {}
    }
}
