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
