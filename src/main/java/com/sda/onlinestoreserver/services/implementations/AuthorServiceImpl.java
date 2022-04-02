package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.AuthorNotFoundException;
import com.sda.onlinestoreserver.models.Author;
import com.sda.onlinestoreserver.repository.AuthorRepository;
import com.sda.onlinestoreserver.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) throws AuthorNotFoundException {
        Author author = findById(id);
        author.setActive(false);
        authorRepository.saveAndFlush(author);
    }

    @Override
    public void restoreAuthorById(Long id) throws AuthorNotFoundException {
        Author author = findById(id);
        author.setActive(true);
        authorRepository.saveAndFlush(author);
    }

    @Override
    public Author findById(Long id) throws AuthorNotFoundException {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException(id);
        }

        return authorOptional.get();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void updateAuthor(Author author) throws AuthorNotFoundException {
        if(findById(author.getId())!= null){
            authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<Author> getAllActive() {
        return authorRepository.findAllByIsActive(true);
    }
}
