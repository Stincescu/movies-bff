package bff.movies.controller;

import bff.movies.dto.MovieDTO;
import bff.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAll());
        //TODO: add lens + add business logic needed + add logs

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(
            @PathVariable("id") String id
    ){
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PostMapping
    public MovieDTO addMovie(
            @RequestBody MovieDTO movieDTO
    ){
        return movieService.create(movieDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteMovie(
            @PathVariable("id") String movieId
    ){
        movieService.delete(movieId);
    }

    @PutMapping("/{id}")
    public void updateMovie(
            @PathVariable("id") String movieId,
            @RequestBody MovieDTO movieDTO
    ){
        movieService.update(movieId, movieDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDTO>> searchMovie(
            @RequestParam("startsWith") String startsWith
    ){
        return ResponseEntity.of(Optional.of(movieService.search(startsWith)));

    }
}
