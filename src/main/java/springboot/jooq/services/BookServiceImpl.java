package springboot.jooq.services;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.jooq.models.tables.Book;
import springboot.jooq.models.tables.records.BookRecord;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private DSLContext dslContext;

    @Override
    public BookRecord findByPrimaryKey(Integer id) {
        return this.dslContext.selectFrom(Book.BOOK).where(Book.BOOK.ID.eq(id)).fetchOne();
    }
}
