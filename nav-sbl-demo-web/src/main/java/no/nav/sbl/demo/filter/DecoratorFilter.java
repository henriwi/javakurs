package no.nav.sbl.demo.filter;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DecoratorFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        WicketResponseWrapper wrapper = new WicketResponseWrapper(httpResponse);

        filterChain.doFilter(request, wrapper);

        Document doc = Jsoup.connect("http://www.nav.no/systemsider/decorator/standard/r6/sok").get();
        Element wicketBody = readWicketResponseBody(wrapper);
        addTitleToDocument(doc);
        String reponseString = insertWicketBodyIntoDocument(wicketBody, doc);

        response.getWriter().write(reponseString);
    }

    private void addTitleToDocument(Document doc) {
        doc.title("Demo@NAV");
    }

    private String insertWicketBodyIntoDocument(Element wicketBody, Document doc) {
        String docString = doc.toString();
        return docString.replace("<!-- ${body} -->", wicketBody.html());
    }

    private Element readWicketResponseBody(WicketResponseWrapper wrapper) {
        String wicketResponseString = wrapper.toString();
        Document wicketResponseDoc = Jsoup.parse(wicketResponseString);
        return wicketResponseDoc.body();
    }

    @Override
    public void destroy() {
    }

    static class WicketResponseWrapper
            extends HttpServletResponseWrapper {

        private PrintWriter pw;
        private CharArrayWriter writer = new CharArrayWriter();

        public WicketResponseWrapper(HttpServletResponse response) {
            super(response);
            pw = new PrintWriter(writer);
        }

        public PrintWriter getWriter() throws IOException {
            return pw;
        }

        public ServletOutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return writer.toString();
        }
    }
}
