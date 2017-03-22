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
package net.livthomas.hystrix.client;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestExecutor {

    private static final long TIMEOUT = 5; // minutes

    private static final Logger log = LoggerFactory.getLogger(RequestExecutor.class);

    private final Set<Callable<String>> executables = new HashSet<>();

    private final int executionsCount;
    private final long waitingTime;

    public RequestExecutor(int executionsCount, long waitingTime) {
        this.executionsCount = executionsCount;
        this.waitingTime = waitingTime;
    }

    public void add(Callable<String> executable) {
        executables.add(executable);
    }

    public void execute() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(executables.size());
        for (Callable<String> executable : executables) {
            executorService.execute(new SafeRunnable(executable));
        }
        executorService.shutdown();
        executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES);
    }

    private class SafeRunnable implements Runnable {

        private final Callable<String> callable;

        public SafeRunnable(Callable<String> callable) {
            this.callable = callable;
        }

        @Override
        public void run() {
            for (int i = 0; i < executionsCount; i++) {
                try {
                    Instant before = Instant.now();

                    String result = callable.call();

                    Instant after = Instant.now();
                    long duration = Duration.between(before, after).toMillis();

                    log.info("{} ms: {}", duration, result);
                } catch (Exception ex) {
                    log.error(ex.toString());
                }
                try {
                    Thread.sleep(waitingTime);
                } catch (InterruptedException ex) {
                    // ignore
                }
            }
        }
    }
}
