package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRespository publisherRespository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRespository publisherRespository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRespository = publisherRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Peterbury");
        publisher.setState("FL");
        publisherRespository.save(publisher);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driver Design","1232354556");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRespository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Davelopment without EJB","32423423");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRespository.save(publisher);
        System.out.println("Start in bootstrap");
        System.out.println("Number of books:  "+bookRepository.count());
        System.out.println("Publisher Number of books: "+publisherRespository.count()+ "number of book: "+publisher.getBooks().size());



    }
}
