package net.livthomas.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class RemoteServiceCommand extends HystrixCommand<String> {

    public RemoteServiceCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("RemoteService"));
    }

    @Override
    protected String run() throws Exception {
        return "Hystrix " + RemoteService.call();
    }
}
