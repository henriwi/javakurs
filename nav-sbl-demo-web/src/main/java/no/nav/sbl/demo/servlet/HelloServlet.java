package no.nav.sbl.demo.servlet;

import no.nav.sbl.demo.web.service.NameService;
import no.nav.sbl.demo.web.service.NameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloServlet extends HttpServlet {

    private NameService nameService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        nameService = (NameService) context.getBean("nameServiceImpl");
        response.getWriter().append("<p>Hello NAV from Servlet</p>" + nameService.getNames());
    }
}
