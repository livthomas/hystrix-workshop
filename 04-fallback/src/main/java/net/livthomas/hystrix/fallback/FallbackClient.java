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
package net.livthomas.hystrix.fallback;

import java.time.Duration;
import java.time.Instant;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import net.livthomas.hystrix.client.WebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FallbackClient {

    private static final Logger log = LoggerFactory.getLogger(FallbackClient.class);

    private static String callFailingService() throws Exception {
        return new FailingServiceCommand().execute();
    }

    public static void main(String[] args) throws Exception {
        WebServer server = new WebServer();
        server.start();
        server.deployServlet("hystrix.stream", "HystrixMetricsStreamServlet", HystrixMetricsStreamServlet.class);

        for (int i = 0; i < 300; i++) {
            try {
                Instant before = Instant.now();

                String result = callFailingService();

                Instant after = Instant.now();
                long duration = Duration.between(before, after).toMillis();

                log.info("{} ms: {}", duration, result);
            } catch (Exception ex) {
                log.error(ex.toString());
            }
            Thread.sleep(400);
        }

        server.stop();
    }
}
