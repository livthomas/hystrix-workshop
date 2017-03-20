package net.livthomas.hystrix.command;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResilientClient {

    private static final Logger log = LoggerFactory.getLogger(RemoteService.class);

    private static String callRemoteService() throws Exception {
        // TODO use Hystrix command here
        return RemoteService.call();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                Instant before = Instant.now();

                String result = callRemoteService();

                Instant after = Instant.now();
                long duration = Duration.between(before, after).toMillis();

                log.info(duration + "ms: " + result);
            } catch (Exception ex) {
                log.error(ex.toString());
            }
        }
    }
}
