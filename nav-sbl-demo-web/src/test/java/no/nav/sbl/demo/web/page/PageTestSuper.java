package no.nav.sbl.demo.web.page;

import no.nav.sbl.demo.web.service.NameService;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class PageTestSuper {
    private ApplicationContextMock mockContext;
    protected WicketTester tester;

    @Mock
    private NameService nameService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        WebApplication wicketApplication = createWicketApplication();
        tester = new WicketTester(wicketApplication);
    }

    private WebApplication createWicketApplication() {
        return new WebApplication() {
            @Override
            public Class<? extends Page> getHomePage() {
                return null;
            }

            @Override
            protected void init() {
                mockContext =  new ApplicationContextMock();
                mockContext.putBean("nameService", nameService);

                when(nameService.getNames()).thenReturn(Arrays.asList("Ole"));

                getComponentInstantiationListeners().add(new SpringComponentInjector(this, mockContext));
            }
        };
    }
}
