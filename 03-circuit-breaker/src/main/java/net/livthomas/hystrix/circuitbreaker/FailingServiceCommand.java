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
package net.livthomas.hystrix.circuitbreaker;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import net.livthomas.hystrix.client.RestClient;

public class FailingServiceCommand extends HystrixCommand<String> {

    private final String servicePath;

    public FailingServiceCommand(String servicePath) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(servicePath))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        .withCircuitBreakerSleepWindowInMilliseconds(2000)));
        this.servicePath = servicePath;
    }

    @Override
    protected String run() throws Exception {
        return RestClient.callService(servicePath);
    }
}
