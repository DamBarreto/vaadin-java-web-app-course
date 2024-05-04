package com.tutorial.vaadin.full.ui;

import com.tutorial.vaadin.full.backend.Book;
import com.tutorial.vaadin.full.backend.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;



import jakarta.annotation.security.RolesAllowed;

@Route("new")
@RolesAllowed("ADMIN")
public class NewBookFormView extends VerticalLayout{

    private TextField title = new TextField("Title");
    private IntegerField rating = new IntegerField("Rating");
    private DatePicker published = new DatePicker("Published");
    
    public NewBookFormView(BookService bookService) {
        var binder = new Binder<>(Book.class);
        binder.bindInstanceFields(this);
        add(
            new H1("New Book"),
            new FormLayout(title, rating, published),
            new Button("Save", event -> {
                var book = new Book();
                if (this.title.isEmpty() || this.rating.isEmpty() || this.published.isEmpty()) {
                    Notification.show("Please fill all fields");
                    return;
                }
                binder.writeBeanIfValid(book);
                bookService.add(book);
                Notification.show("Book saved");
                binder.readBean(new Book());
            })
        );
    }
    
}
