package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.AuthorNotFoundException;
import com.sda.onlinestoreserver.models.Author;


import java.util.List;

public interface AuthorService {
    /**
     * To create a new author
     * @param author Author
     */
    void createAuthor(Author author);

    /**
     * To delete author by its id
     * @param id Author id
     */
    void deleteAuthorById(Long id) throws AuthorNotFoundException;

    /**
     * To restore author by its id
     * @param id of the author
     * @throws AuthorNotFoundException if no author
     */
    void restoreAuthorById(Long id) throws AuthorNotFoundException;

    /**
     * To find author by its id
     * @param id author id
     * @return author by id
     * @throws AuthorNotFoundException if no author
     */
    Author findById(Long id) throws AuthorNotFoundException;

    /**
     * To get all author
     * @return all author
     */
    List<Author> getAll();


    /**
     * To update existing author
     * @param author modified author
     */
    void updateAuthor(Author author) throws AuthorNotFoundException;
}
