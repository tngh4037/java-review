package adv2.was.v5;

import adv2.was.httpserver.HttpServer;
import adv2.was.httpserver.ServletManager;
import adv2.was.httpserver.servlet.DiscardServlet;
import adv2.was.v5.servlet.HomeServlet;
import adv2.was.v5.servlet.SearchServlet;
import adv2.was.v5.servlet.Site1Servlet;
import adv2.was.v5.servlet.Site2Servlet;

import java.io.IOException;

public class ServerMainV5 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();
        servletManager.add("/", new HomeServlet());
        servletManager.add("/site1", new Site1Servlet());
        servletManager.add("/site2", new Site2Servlet());
        servletManager.add("/search", new SearchServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
