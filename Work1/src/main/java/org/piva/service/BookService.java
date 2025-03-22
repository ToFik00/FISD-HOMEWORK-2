package org.piva.service;

import org.piva.entity.Book;
import org.piva.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Optional<Book> update(Long id, Book updatedData) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(updatedData.getTitle());
            existingBook.setAuthor(updatedData.getAuthor());
            existingBook.setYear(updatedData.getYear());
            return bookRepository.save(existingBook);
        });
    }

    @Transactional
    public boolean delete(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
