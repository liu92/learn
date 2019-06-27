package org.boot.controller;

import org.boot.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName MovieController
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/5/14 14:07
 **/
@RestController
@RequestMapping("/")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/graph")
    public Map<String,Object> graph(@RequestParam(value = "limit",required = false) Integer limit){
        return movieService.graph(limit == null ? 100 : limit);
    }
}
