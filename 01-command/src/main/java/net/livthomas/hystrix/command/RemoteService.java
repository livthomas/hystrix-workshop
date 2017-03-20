package net.livthomas.hystrix.command;

public class RemoteService {

    private static final double FAILURE_RATE = 0.5;
    private static final int MAX_WAITING = 1000; // in milliseconds

    public static String call() throws Exception {
        long waitingTime = Math.round(Math.random() * MAX_WAITING);
        Thread.sleep(waitingTime);

        boolean fail = Math.round(Math.random()) < FAILURE_RATE;
        if (fail) {
            throw new RuntimeException("service failure");
        }

        return "success";
    }
}
