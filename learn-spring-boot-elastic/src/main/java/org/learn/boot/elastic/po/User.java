package org.learn.boot.elastic.po;

import io.searchbox.annotations.JestId;
import lombok.Data;

/**
 * @ClassName: User
 * @Description:
 * @Author: lin
 * @Date: 2019/9/27 11:45
 * History:
 * @<version> 1.0
 */
@Data
public class User {
    /**
     *    @JestId 表示主键
     */
    @JestId
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
