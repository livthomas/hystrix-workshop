# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## 4. Fallback

The fourth assignment is focused on a configuration of fallbacks in Hystrix commands.
You will try to use a fallback when the remote service fails.

Follow these steps:

1. Start the remote server with unstable services.
    1. Explore the code in [FailingService](https://github.com/livthomas/hystrix-workshop/blob/master/unstable-server/src/main/java/net/livthomas/hystrix/server/FailingService.java) class.
    1. Start the [Unstable Server](https://github.com/livthomas/hystrix-workshop/tree/master/unstable-server) unless it is already running.
1. Call the remote service using a Hystrix command without fallback.
    1. Explore the code in [FallbackClient](https://github.com/livthomas/hystrix-workshop/blob/master/04-fallback/src/main/java/net/livthomas/hystrix/fallback/FallbackClient.java) class.
    1. Explore the code in [FailingServiceCommand](https://github.com/livthomas/hystrix-workshop/blob/master/04-fallback/src/main/java/net/livthomas/hystrix/fallback/FailingServiceCommand.java) class.
    1. Run `FallbackClient` and observe the console output.
1. Call the remote service using a command with fallback.
    1. Read about [Fallback](https://github.com/Netflix/Hystrix/wiki/How-To-Use#Fallback) configuration in a Hystrix command.
    1. Modify `FailingServiceCommand` to use fallback and return some value.
    1. Run `FallbackClient` and observe the console output. See the different execution times when the fallback is used.
