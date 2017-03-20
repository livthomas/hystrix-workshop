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
