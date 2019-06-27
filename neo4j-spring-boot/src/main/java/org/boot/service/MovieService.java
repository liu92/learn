package org.boot.service;

import org.boot.entity.Movie;
import org.boot.entity.Role;
import org.boot.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName MovieService
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/5/14 11:18
 **/
@Service
public class MovieService {

    private final static Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository movieRepository;
    //这里注意构造器
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public Movie findByTitle(String title){
        return  movieRepository.findByTitle(title);
    }

    @Transactional(readOnly = true)
    public Collection<Movie> findByTitleLike(String title){
        return  movieRepository.findByTitleLike(title);
    }

    @Transactional(readOnly = true)
    public Map<String,Object> graph(int limit){
        Collection<Movie> result = movieRepository.graph(limit);
        return  toFormat(result);
    }

    private Map<String,Object> toFormat(Collection<Movie> movies){
        List<Map<String,Object>>  nodes = new ArrayList<>();
        List<Map<String,Object>>  rels = new ArrayList<>();
        int i=0;
        Iterator<Movie> result = movies.iterator();
        while (result.hasNext()){
            Movie movie = result.next();
            nodes.add(map("title",movie.getTitle(),"label","movie"));
            int target =i;
            i++;
            for (Role role: movie.getRoles()){
                Map<String, Object> actor = map("title",role.getPerson().getName(),"label","actor");
                int source = nodes.indexOf(actor);
                if(source ==-1){
                    nodes.add(actor);
                    source = i++;
                }
                rels.add(map("source","source","targe",target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    private Map<String,Object> map(String key1, Object value1, String key2, Object value2){
        Map<String,Object> result = new HashMap<>(2);
        result.put(key1,value1);
        result.put(key2,value2);
        return  result;
    }
}
