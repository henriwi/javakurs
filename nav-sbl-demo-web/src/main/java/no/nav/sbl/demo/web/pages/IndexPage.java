package no.nav.sbl.demo.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class IndexPage extends WebPage {

    public IndexPage() {
        add(new Label("message", "Hello NAV!"));
    }

}
