# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## 3. Circuit Breaker

The third assignment is focused on a configuration of circuit breakers in Hystrix commands.
You will try to set timeouts for the remote service and visualize the execution using Hystrix Dashboard.

Follow these steps:

1. Start the remote server with unstable services.
    1. Explore the code in [FailingService](https://github.com/livthomas/hystrix-workshop/blob/master/unstable-server/src/main/java/net/livthomas/hystrix/server/FailingService.java) class.
    1. Start the [Unstable Server](https://github.com/livthomas/hystrix-workshop/tree/master/unstable-server) unless it is already running.
1. Call the remote service directly.
    1. Explore the code in [CircuitBreakerClient](https://github.com/livthomas/hystrix-workshop/blob/master/03-circuit-breaker/src/main/java/net/livthomas/hystrix/circuitbreaker/CircuitBreakerClient.java) class.
    1. Run `CircuitBreakerClient` and observe the console output.
1. Implement a Hystrix command for the remote service.
    1. Create a new Hystrix command implementation.
    1. Call the remote service in `run` method.
    1. Execute the command in `CircuitBreakerClient` (instead of direct service call).
    1. Run `CircuitBreakerClient` and observe the console output. The command will start short-circuiting after a while.
1. Visualize the execution in Hystrix Dashboard.
    1. Go to [http://localhost:8080/hystrix-dashboard/](http://localhost:8080/hystrix-dashboard/)
    1. Enter `http://localhost:8181/hystrix.stream` to the second input field.
    1. Click _Add Stream_ and then _Monitor Streams_ button.
    1. Observe the execution in the shown graphs.
1. Change the circuit breaker properties in your command.
    1. Read about [Circuit Breaker](https://github.com/Netflix/Hystrix/wiki/Configuration#CommandCircuitBreaker) configuration of Hystrix commands.
    1. Set request volume threshold to `10` and sleep window to `2000` ms.
    1. Run `CircuitBreakerClient` and observe the console output.
    1. Observe the execution in Hystrix Dashboard.
