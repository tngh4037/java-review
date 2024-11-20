package adv2.was.httpserver;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HttpResponse {

    private final PrintWriter writer;

    private int statusCode = 200;
    private String contentType = "text/html; charset=UTF-8";
    private final StringBuilder bodyBuilder = new StringBuilder();

    public HttpResponse(PrintWriter writer) {
        this.writer = writer;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void writeBody(String body) {
        bodyBuilder.append(body);
    }

    public void flush() {
        int contentLength = bodyBuilder.toString().getBytes(StandardCharsets.UTF_8).length;
        writer.println("HTTP/1.1 " + statusCode + " " + getReasonPhase(statusCode));
        writer.println("Content-Type: " + contentType);
        writer.println("Content-Length: " + contentLength);
        writer.println();
        writer.println(bodyBuilder.toString());
        writer.flush();
    }

    private String getReasonPhase(int statusCode) {
        switch (statusCode) {
            case 200:
                return "OK";
            case 404:
                return "Not Found";
            case 500:
                return "Integer Server Error";
            default:
                return "Unknown Status";
        }
    }
}
