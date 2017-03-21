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

@Path("timeout")
public class TimeoutService {

    private static final int MAX_WAITING = 2000; // in milliseconds

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response timeout(@QueryParam("wait") Long wait) throws Exception {
        if (wait == null) {
            wait = Math.round(Math.random() * MAX_WAITING);
        }
        Thread.sleep(wait);

        return Response.ok("You have waited " + wait + " ms.").build();
    }
}
