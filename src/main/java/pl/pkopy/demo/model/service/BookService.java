package pl.pkopy.demo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pkopy.demo.model.BookEntity;
import pl.pkopy.demo.model.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

//    Iterable<BookEntity> bookEntity = bookRepository.findAll();


//    public boolean isExist(BookForm bookForm) {
//        Iterable<BookEntity> books = bookRepository.findAll();
//
//        for(BookEntity book : books){
//            if (book.getTitle().equals(bookForm.getUser())){
//
//                return true;
//            }
//
//        }
//        return false;
//    }
}
