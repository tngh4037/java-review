package adv2.was.v5.servlet;

import adv2.was.httpserver.HttpRequest;
import adv2.was.httpserver.HttpResponse;
import adv2.was.httpserver.HttpServlet;

public class HomeServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site2'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>검색</a></li>");
        response.writeBody("</ul>");
    }
}
