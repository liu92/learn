package org.learn.boot.elastic.po;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName: Book
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 16:08
 * History:
 * @<version> 1.0
 */
@Data
@Document(indexName = "lin", type = "book")
public class Book {
    private int id;
    private String bookName;
    private String authorId;
}
