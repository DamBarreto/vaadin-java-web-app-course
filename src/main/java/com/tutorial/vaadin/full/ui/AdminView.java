package com.tutorial.vaadin.full.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.tutorial.vaadin.full.backend.Book;
import com.tutorial.vaadin.full.backend.BookService;

import jakarta.annotation.security.RolesAllowed;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {
    
    public AdminView(BookService bookService) {
        var crud = new GridCrud<>(Book.class, bookService);
        crud.getGrid().setColumns("title", "rating", "published");
        crud.getCrudFormFactory().setVisibleProperties("title", "rating", "published");
        crud.setAddOperationVisible(false);
        crud.getCrudLayout().addToolbarComponent(new RouterLink("New Book", NewBookFormView.class));

        add(
            new H1("Admin View"),
            crud
        );
    }
}
