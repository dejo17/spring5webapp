/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.scorpiusmobile.spring5webapp.bootstrap;

import hr.scorpiusmobile.spring5webapp.model.Author;
import hr.scorpiusmobile.spring5webapp.model.Book;
import hr.scorpiusmobile.spring5webapp.model.Publisher;
import hr.scorpiusmobile.spring5webapp.model.repositories.AuthorRepository;
import hr.scorpiusmobile.spring5webapp.model.repositories.BookRepository;
import hr.scorpiusmobile.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dejo
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initData();
    }

    private void initData() {

        //Eric
        Publisher harper = new Publisher("Harper Collins", "Some Address 3");
        publisherRepository.save(harper);

        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Publisher worx = new Publisher("Worx", "Worx Address 54A");
        publisherRepository.save(worx);

        Author rod = new Author("Rod", "Johnson");

        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

}
