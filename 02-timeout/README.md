# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## 2. Timeouts

The second assignment is focused on a configuration of timeouts in Hystrix commands.
You will try to set timeouts for the remote service and visualize the execution using Hystrix Dashboard.

Follow these steps:

1. Start the remote server with unstable services.
    1. Explore the code in [TimeoutService](https://github.com/livthomas/hystrix-workshop/blob/master/unstable-server/src/main/java/net/livthomas/hystrix/server/TimeoutService.java) class.
    1. Start the [Unstable Server](https://github.com/livthomas/hystrix-workshop/tree/master/unstable-server) unless it is already running.
1. Call the remote service directly.
    1. Explore the code in [TimeoutClient](https://github.com/livthomas/hystrix-workshop/blob/master/02-timeout/src/main/java/net/livthomas/hystrix/timeout/TimeoutClient.java) class.
    1. Run `TimeoutClient` and observe the console output.
1. Implement a Hystrix command for the remote service.
    1. Create a new Hystrix command implementation.
    1. Call the remote service in `run` method.
    1. Execute the command in `TimeoutClient` (instead of direct service call).
    1. Run `TimeoutClient` and observe the console output.
1. Visualize the execution in Hystrix Dashboard.
    1. Go to [http://localhost:8080/hystrix-dashboard/](http://localhost:8080/hystrix-dashboard/)
    1. Enter `http://localhost:8181/hystrix.stream` to the second input field.
    1. Click _Add Stream_ and then _Monitor Streams_ button.
    1. Observe the execution in the shown graphs.
1. Change the timeout in your command.
    1. Read about the [Configuration](https://github.com/Netflix/Hystrix/wiki/Configuration) of Hystrix commands.
    1. Set the timeout to _2000_ ms.
    1. Run `TimeoutClient` and observe the console output.
    1. Observe the execution in Hystrix Dashboard.
