package com.tutorial.vaadin.full.backend;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookService implements CrudListener<Book>{

    private final BookRepository bookRepository;
    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }
    
}
