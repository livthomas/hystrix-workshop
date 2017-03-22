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
package net.livthomas.hystrix.threadpool;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import net.livthomas.hystrix.client.RequestExecutor;
import net.livthomas.hystrix.client.WebServer;

public class ThreadPoolClient {

    public static void main(String[] args) throws Exception {
        WebServer server = new WebServer();
        server.start();
        server.deployServlet("hystrix.stream", "HystrixMetricsStreamServlet", HystrixMetricsStreamServlet.class);

        RequestExecutor executor = new RequestExecutor(600, 500);

        executor.add(() -> new FailingServiceCommand("group1", "command01").execute());
        executor.add(() -> new FailingServiceCommand("group1", "command02").execute());
        executor.add(() -> new FailingServiceCommand("group2", "command03").execute());
        executor.add(() -> new FailingServiceCommand("group2", "command04").execute());
        executor.add(() -> new FailingServiceCommand("group3", "command05").execute());
        executor.add(() -> new FailingServiceCommand("group3", "command06").execute());

        executor.execute();

        server.stop();
    }
}
