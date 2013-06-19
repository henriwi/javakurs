package no.nav.sbl.demo.web.pages;

import no.nav.sbl.demo.web.panels.NavnelistePanel;
import no.nav.sbl.demo.web.service.NameService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

public class IndexPage extends WebPage {

    @SpringBean
    private NameService nameService;

    public IndexPage() {
        add(new Label("message", "Hello NAV!"));

        List<String> names = nameService.getNames();
        add(new NavnelistePanel("navnelistePanel", names));
    }

}
