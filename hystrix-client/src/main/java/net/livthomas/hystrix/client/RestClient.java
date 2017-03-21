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

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient {

    private static final String SERVER_URL = "http://localhost:8080/unstable-server";

    public static String callService(String servicePath) throws Exception {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(SERVER_URL).path(servicePath);

        Response response = null;
        try {
            response = target.request().get();
            return response.readEntity(String.class);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
