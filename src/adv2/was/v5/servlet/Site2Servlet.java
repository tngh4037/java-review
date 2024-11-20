package adv2.was.v5.servlet;

import adv2.was.httpserver.HttpRequest;
import adv2.was.httpserver.HttpResponse;
import adv2.was.httpserver.HttpServlet;

public class Site2Servlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }
}
