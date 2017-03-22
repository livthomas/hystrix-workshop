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

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import net.livthomas.hystrix.client.RestClient;

/**
 * TODO add fallback
 */
public class FailingServiceCommand extends HystrixCommand<String> {

    private static final String SERVICE_PATH = "fail";

    public FailingServiceCommand() {
        super(HystrixCommandGroupKey.Factory.asKey(SERVICE_PATH));
    }

    @Override
    protected String run() throws Exception {
        return RestClient.callService(SERVICE_PATH);
    }
}
