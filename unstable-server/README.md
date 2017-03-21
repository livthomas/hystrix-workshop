# Hystrix Workshop

This course teaches the basics of [Hystrix](https://github.com/Netflix/Hystrix) fault tolerance library which will help you build resilient distributed applications.

You can find the list of all assignments on [Hystrix Workshop](https://github.com/livthomas/hystrix-workshop) page.

## Unstable Server

This unstable server application have been developed to demonstrate Hystrix features.
It necessary to run it when working on some of the assignments.

The following command executed in `unstable-server` directory will start WildFly application server and deploy the unstable application into it:

```
$ mvn clean install cargo:run
```
