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
package net.livthomas.hystrix.client;

import javax.servlet.Servlet;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ServletInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

public class WebServer {

    private static final String HOST = "localhost";
    private static final int PORT = 8181;

    private final UndertowJaxrsServer server;

    public WebServer() {
        this.server = new UndertowJaxrsServer();
    }

    public void deployServlet(String contextPath, String servletName, Class<? extends Servlet> servletClass) {
        DeploymentInfo servletBuilder = Servlets
                .deployment()
                .setClassLoader(this.getClass().getClassLoader())
                .setContextPath(contextPath)
                .setDeploymentName(servletName);

        ServletInfo servletInfo = Servlets.servlet(servletName, servletClass);
        servletInfo.addMapping("/");
        servletBuilder.addServlet(servletInfo);

        server.deploy(servletBuilder);
    }

    public void start() {
        Undertow.Builder builder = Undertow.builder().addHttpListener(PORT, HOST);
        server.start(builder);
    }

    public void stop() {
        server.stop();
    }
}
