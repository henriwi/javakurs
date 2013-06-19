package no.nav.sbl.demo.web.page;

import no.nav.sbl.demo.web.pages.IndexPage;
import org.junit.Test;

public class IndexPageTest extends PageTestSuper {


    @Test
    public void sideKanRendres() {
        tester.startPage(IndexPage.class);
        tester.assertRenderedPage(IndexPage.class);
    }

    @Test
    public void viserKorrektMelding() {
        tester.startPage(IndexPage.class);
        tester.assertLabel("message", "Hello NAV!");
    }

    @Test
    public void viserKorrektNavn() {
        tester.startPage(IndexPage.class);
        tester.assertLabel("navnelistePanel:navneliste:0:navn", "Ole");
    }
}
