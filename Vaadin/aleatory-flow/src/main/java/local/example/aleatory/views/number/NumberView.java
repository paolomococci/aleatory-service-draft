package local.example.aleatory.views.number;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import local.example.aleatory.views.MainLayout;

@PageTitle("Number")
@Route(value = "number", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class NumberView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public NumberView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

}
