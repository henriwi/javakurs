package no.nav.sbl.demo.web.panels;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.List;

public class NavnelistePanel extends Panel {

    public NavnelistePanel(String id, List<String> names) {
        super(id);

        ListView<String> navneListe = new PropertyListView<String>("navneliste", names) {

            @Override
            protected void populateItem(ListItem<String> item) {
                item.add(new Label("navn", item.getModel()));
            }
        };
        add(navneListe);
    }

}
