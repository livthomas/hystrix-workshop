# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## 5. Thread Pool Management

The fifth assignment is focused on the configuration of thread pools used by Hystrix when executing commands.
You will try to make multiple commands use the same thread pool as well as use different thread pools for different commands.

Follow these steps:

1. Start the remote server with unstable services.
    1. Explore the code in [FailingService](https://github.com/livthomas/hystrix-workshop/blob/master/unstable-server/src/main/java/net/livthomas/hystrix/server/FailingService.java) class.
    1. Start the [Unstable Server](https://github.com/livthomas/hystrix-workshop/tree/master/unstable-server) unless it is already running.
1. Call the remote service using multiple Hystrix commands.
    1. Read about [Command Name](https://github.com/Netflix/Hystrix/wiki/How-To-Use#CommandName) and [Command Group](https://github.com/Netflix/Hystrix/wiki/How-To-Use#CommandGroup).
    1. Explore the code in [ThreadPoolClient](https://github.com/livthomas/hystrix-workshop/blob/master/05-thread-pool/src/main/java/net/livthomas/hystrix/threadpool/ThreadPoolClient.java) class.
    1. Run `ThreadPoolClient` and observe its behavior in Hystrix Dashboard.
1. Use a single thread pool for all commands.
    1. Read about [Command Thread Pool](https://github.com/Netflix/Hystrix/wiki/How-To-Use#CommandThreadPool) configuration.
    1. Modify `FailingServiceCommand` to use a single thread pool key for every instance.
    1. Run `ThreadPoolClient` and observe its behavior in Hystrix Dashboard. See the number of active threads.
1. Lower the size of the thread pool.
    1. Read about [Thread Pool Properties](https://github.com/Netflix/Hystrix/wiki/Configuration#ThreadPool).
    1. Modify `FailingServiceCommand` to use the core thread pool of size `2`.
    1. Run `ThreadPoolClient` and observe its behavior in Hystrix Dashboard. See that some requests get rejected.
