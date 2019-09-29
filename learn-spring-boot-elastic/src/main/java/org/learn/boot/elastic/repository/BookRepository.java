package org.learn.boot.elastic.repository;

import org.learn.boot.elastic.po.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName: UserRepository
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 16:08
 * @History:
 * @<version> 1.0
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer>{

    /**
     * 在spring-data-elasticsearch官方文档中
     * https://docs.spring.io/spring-data/elasticsearch/docs/3.1.10.RELEASE/reference/html/
     * 2.2.2. Query creation
     * 自定义查询
     * @param bookName
     * @return
     */
    Book findByBookName(String bookName);
}

