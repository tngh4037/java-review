package adv2.was.webservice;

import adv2.io.member.impl.FileMemberRepository;
import adv2.was.httpserver.HttpServer;
import adv2.was.httpserver.HttpServlet;
import adv2.was.httpserver.ServletManager;
import adv2.was.httpserver.servlet.DiscardServlet;
import adv2.was.httpserver.servlet.annotation.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        FileMemberRepository memberRepository = new FileMemberRepository();
        MemberController memberController = new MemberController(memberRepository);
        HttpServlet servlet = new AnnotationServletV3(List.of(memberController));

        ServletManager servletManager = new ServletManager();
        servletManager.add("/favicon.ico", new DiscardServlet());
        servletManager.setDefaultServlet(servlet);

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
