package springboot.jooq.services;

import springboot.jooq.models.tables.records.BookRecord;

public interface BookService {
    BookRecord findByPrimaryKey(Integer id);
}
