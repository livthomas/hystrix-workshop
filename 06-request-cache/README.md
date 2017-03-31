# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## 6. Request Cache

The sixth assignment is focused on Hystrix request caching.
You will use request cache to avoid making unnecessary remote calls within the same request context.

Follow these steps:

1. Call the remote service without caching.
    1. Explore the code in `RequestCacheClient`, `RequestCacheCommand`, and `EchoService` class.
    1. Run `RequestCacheClient` and observe the console output.
1. Turn on request caching so the remote service is not called every time a command is executed.
    1. Read about [Request Context](https://github.com/Netflix/Hystrix/wiki/How-To-Use#RequestContextSetup) in Hystrix wiki.
    1. Read about [Request Cache](https://github.com/Netflix/Hystrix/wiki/How-To-Use#Caching) in Hystrix wiki.
    1. Modify `RequestCacheCommand` to enable request caching.
    1. Run `RequestCacheClient` and observe the console output.
1. Limit request cache item validity.
    1. Modify `RequestCacheCommand` to get items from cache only within the same second.
    1. Run `RequestCacheClient` and observe the console output.
