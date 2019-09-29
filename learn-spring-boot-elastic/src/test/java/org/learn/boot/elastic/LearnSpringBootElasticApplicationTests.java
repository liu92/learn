package org.learn.boot.elastic;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.boot.elastic.po.Book;
import org.learn.boot.elastic.po.User;
import org.learn.boot.elastic.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringBootElasticApplicationTests {

	@Autowired
	JestClient jestClient;

    @Autowired
	BookRepository bookRepository;


	/**
	 * 测试 spring data elasticsearch,
	 * 但是要注意的是 spring-data-elasticsearch 中的 elasticsearch 版本 要和 服务器中版本一直不然，启动会报错
	 */
	@Test
    public void testBook(){
		Book book = new Book();
		book.setId(1);
		book.setBookName("活着");
		book.setAuthorId("2");
		bookRepository.index(book);
	}


	@Test
	public void testSearchName(){
		Book bookName = bookRepository.findByBookName("活着");
		System.out.println(bookName);
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void testElastic(){
		//给es 中索引保存一个文档
		User user = new User();
		user.setId(1);
		user.setName("小明");
		user.setAge(10);
		user.setSex("男");

		//构建索引功能
		Index build = new Index.Builder(user).index("lin").type("news").build();

		try {
			//执行
			jestClient.execute(build);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void  testSearch(){
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"name\" : \"明\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		//构建搜索
		Search build = new Search.Builder(json).addIndex("lin").addType("news").build();

		try {
			SearchResult execute = jestClient.execute(build);
			System.out.println(execute.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

















}
