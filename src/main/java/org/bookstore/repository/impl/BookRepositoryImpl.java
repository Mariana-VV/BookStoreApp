package org.bookstore.repository.impl;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.bookstore.mapper.BookMapper;
import org.bookstore.model.Book;
import org.bookstore.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;
    private final BookMapper bookMapper;

    @Override
    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public List findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select b from Book b").getResultList();
        }
    }

    public Optional<Book> findById(Long id) {
        try (EntityManager entityManager = sessionFactory.openSession()) {
            Book book = entityManager.find(Book.class, id);
            return Optional.ofNullable(book);
        }
    }

    @Override
    public List<Book> getAllByName(String title) {
        String nameToLowerCase = title.toLowerCase();
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select b from Book b "
                            + "where lower(b.title) like :name", Book.class)
                    .setParameter("name", "%" + nameToLowerCase + "%")
                    .getResultList();
        }
    }
}
