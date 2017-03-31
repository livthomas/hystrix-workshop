/*
 * Copyright 2017 livthomas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.livthomas.hystrix.cache;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

public class RequestCacheClient {

    private static final int WAIT_BETWEEN = 250; // in milliseconds

    private static final String MESSAGE_1 = "message1";
    private static final String MESSAGE_2 = "message2";

    private static final Logger log = LoggerFactory.getLogger(RequestCacheClient.class);

    private static String callRemoteService(String message) throws Exception {
        return new RequestCacheCommand(message).execute();
    }

    public static void main(String[] args) {
        HystrixRequestContext.initializeContext();

        callServiceMultipleTimes(MESSAGE_1);
        callServiceMultipleTimes(MESSAGE_2);

        log.info("Number of EchoService calls: {}", EchoService.COUNTER);
    }

    private static void callServiceMultipleTimes(String message) {
        for (int i = 0; i < 10; i++) {
            try {
                Instant before = Instant.now();

                String result = callRemoteService(message);

                Instant after = Instant.now();
                long duration = Duration.between(before, after).toMillis();

                log.info(duration + "ms: " + result);

                Thread.sleep(WAIT_BETWEEN);
            } catch (Exception ex) {
                log.error(ex.toString());
            }
        }
    }
}
