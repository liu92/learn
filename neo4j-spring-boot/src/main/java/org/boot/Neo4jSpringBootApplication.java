package org.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * 功能描述: <br>
 * 〈〉
 *
 * @return:
 * @since: 1.0.0
 * @Author:lin
 * @Date: 2019/5/14 22:21
 */

@SpringBootApplication
@EnableNeo4jRepositories("org.boot.repository")
public class Neo4jSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jSpringBootApplication.class, args);
	}

}
