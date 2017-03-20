# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## 1. Basic Command Execution

The first assignment is focused on a basic usage of Hystrix commands.
You will use Hystrix to wrap a remote service call instead of making a direct call.

Follow these steps:

1. Call the remote service directly.
    1. Explore the code in `ResilientClient` class and `RemoteService` class.
    2. Run `ResilientClient` and observe the console output.
2. Implement a Hystrix command for the remote service.
    1. Look at Hystrix [hello world](https://github.com/Netflix/Hystrix/wiki/How-To-Use#Hello-World) example.
    2. Create `RemoteServiceCommand` class.
    3. Call the remote service in `run` method.
2. Call the remote service using Hystrix command.
    1. Read about [Synchronous Execution](https://github.com/Netflix/Hystrix/wiki/How-To-Use#Synchronous-Execution) in Hystrix wiki.
    2. Execute the command in `ResilientClient` (instead of direct service call).
    3. Run `ResilientClient` and observe the console output.
3. Call the remote service asynchronously.
    1. Read about [Asynchronous Execution](https://github.com/Netflix/Hystrix/wiki/How-To-Use#Asynchronous-Execution) in Hystrix wiki.
    2. Execute the command asynchronously in `AsynchronousClient`.
    3. Run `AsynchronousClient` and observe the console output.
