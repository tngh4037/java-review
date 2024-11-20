package adv2.was.httpserver.servlet;

import adv2.was.httpserver.HttpRequest;
import adv2.was.httpserver.HttpResponse;
import adv2.was.httpserver.HttpServlet;

// ex. /favicon.ico
public class DiscardServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        // empty
    }
}
