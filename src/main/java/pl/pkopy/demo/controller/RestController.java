package pl.pkopy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pkopy.demo.model.BookEntity;
import pl.pkopy.demo.model.Config;
import pl.pkopy.demo.model.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class RestController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping(value = "/rest/{id}", produces = "application/json")
    public ResponseEntity getBook(@PathVariable("id") int id){

        Optional<BookEntity> bookEntity = bookRepository.findById(id);


        return bookEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

//        Iterable<BookEntity> bookEntity = bookRepository.findAll();
//
//        return ResponseEntity.ok(bookEntity);

    }

    @GetMapping(value = "/rest", produces = "application/json")
    public ResponseEntity getAllBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @PostMapping(value = "/rest", consumes = "application/json")
    public ResponseEntity createBook(@RequestHeader("key") String key,@RequestBody BookEntity bookEntity) {

        if(checkKey(key)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if(bookRepository.existsByTitle(bookEntity.getTitle())){
            System.out.println("jest w bazie");
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        bookRepository.save(bookEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/rest/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/rest", consumes = "application/json")
    public ResponseEntity editBook(@RequestBody BookEntity bookEntity){
        if(!bookRepository.existsById(bookEntity.getId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        bookRepository.save(bookEntity);
        return ResponseEntity.ok().build();
    }

    private boolean checkKey( String key){
        if(!key.equals(Config.API_KEY)){
            return true;
        }else{
            return false;
        }
    }





}
