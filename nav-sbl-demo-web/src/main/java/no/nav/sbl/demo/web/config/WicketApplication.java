package no.nav.sbl.demo.web.config;

import no.nav.sbl.demo.web.pages.IndexPage;
import org.apache.wicket.Page;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WicketApplication extends WebApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(WicketApplication.class);

    @Override
    public Class<? extends Page> getHomePage() {
        return IndexPage.class;
    }

    @Override
    public void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        //Injector.get().inject(this);
        LOGGER.info("Initialized!");
    }


}
