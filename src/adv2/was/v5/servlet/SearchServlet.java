package adv2.was.v5.servlet;

import adv2.was.httpserver.HttpRequest;
import adv2.was.httpserver.HttpResponse;
import adv2.was.httpserver.HttpServlet;

public class SearchServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + request.getParameter("q") + "</li>");
        response.writeBody("</ul>");
    }
}
