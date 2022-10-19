package com.nestdigital.moviebackendapp.controller;

import com.nestdigital.moviebackendapp.dao.MovieDao;
import com.nestdigital.moviebackendapp.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/movieadd",consumes = "application/json",produces = "application/json")
    public String movie(@RequestBody MovieModel movie)
    {
        dao.save(movie);
        return "{status:success}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewmovies")
    public List<MovieModel> viewmovies()
    {
        return (List<MovieModel>)dao.findAll() ;
    }


}
