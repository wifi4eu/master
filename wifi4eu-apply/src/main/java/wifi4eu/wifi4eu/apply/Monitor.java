package wifi4eu.wifi4eu.apply;

public class Monitor {

    private static long numReceived  = 0;
    private static long numProcessed = 0;


    public static synchronized long addReceived(long n) {

        numReceived += n;
        return numReceived;
    }

    public static synchronized long addReceived() {

        return ++numReceived;
    }

    public static synchronized long addProcessed() {

        return ++numProcessed;
    }


    public static synchronized long addProcessed(long n) {

        numProcessed += n;

        return numProcessed;
    }


    public static long getReceived() {
        return numReceived;
    }

    public static long getProcessed() {
        return numProcessed;
    }
}
