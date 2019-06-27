package org.boot;

import org.boot.entity.Movie;
import org.boot.entity.Person;
import org.boot.entity.Role;
import org.boot.repository.MovieRepository;
import org.boot.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class Neo4jSpringBootApplicationTests {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private PersonRepository personRepository;

	@Before
	public void setUp(){
		Movie matrix = new Movie("The Matrix",2000,"hello");
		movieRepository.save(matrix);

		Person keanu = new Person("Keanu",2001);
		personRepository.save(keanu);

		Role neo = new Role(matrix,keanu);
		neo.addRoleName("Neo");
		matrix.addRole(neo);

		movieRepository.save(matrix);
	}

	@Test
	public void testFindByTitle(){
		String title = "The Matrix";
		Movie result = movieRepository.findByTitle(title);
		assertNotNull(result);
		assertNotEquals(2000,result.getReleased());
	}

	@Test
	public void testFindByTitleContaining(){
		String title = "*Matrix*";
		Collection<Movie> result = movieRepository.findByTitleLike(title);
		assertNotNull(result);
		assertEquals(1,result.size());
	}

	@Test
	public void testGraph(){
		Collection<Movie> graph = movieRepository.graph(5);
		assertEquals(1,graph.size());
		Movie movie = graph.iterator().next();

		assertEquals(1,movie.getRoles().size());
		assertEquals("The Matrix", movie.getTitle());
		assertEquals("Keanu", movie.getRoles().iterator().next().getPerson().getName());
	}



}
