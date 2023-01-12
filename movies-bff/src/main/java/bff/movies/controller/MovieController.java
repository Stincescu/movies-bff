package bff.movies.controller;

import bff.movies.dto.MovieDTO;
import bff.movies.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Resource
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        log.info("Request to return all movies");
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(
            @PathVariable("id") @NotNull String movieId
    ){
        log.info("Request to return movie with id=" + movieId);
        return ResponseEntity.ok(movieService.getById(movieId));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(
            @RequestBody MovieDTO movieDTO
    ){
        log.info("Request to create movie");
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(
            @PathVariable("id") @NotNull String movieId
    ){
        log.info("Request to delete movie with id=" + movieId);
        movieService.delete(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(
            @PathVariable("id") @NotNull String movieId,
            @RequestBody MovieDTO movieDTO
    ){
        log.info("Request to update movie with id=" + movieId);
        movieService.update(movieId, movieDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/search")
    public ResponseEntity<Optional> searchMovie(
            @RequestParam("startsWith") String startsWith
    ){
        log.info("Request to search for movie starting with startsWith=" + startsWith);

        Optional response = Optional.of(movieService.search(startsWith));

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
