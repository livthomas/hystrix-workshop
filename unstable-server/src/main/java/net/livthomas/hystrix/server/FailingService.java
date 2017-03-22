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
package net.livthomas.hystrix.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("fail")
public class FailingService {

    private static final double FAILURE_RATE = 0.5;
    private static final long DEFAULT_DELAY = 100; // milliseconds

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response fail(@QueryParam("delay") Long delay) throws Exception {
        Thread.sleep(delay != null ? delay : DEFAULT_DELAY);

        boolean fail = Math.round(Math.random()) < FAILURE_RATE;
        if (fail) {
            return Response.serverError().build();
        }

        return Response.ok("success").build();
    }
}
