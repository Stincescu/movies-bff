package bff.movies.repository;

import bff.movies.dto.MovieDTO;

import java.util.List;

public interface MovieRepository {
    List<MovieDTO> getAlL();

    MovieDTO getById(String id);

    MovieDTO create(MovieDTO movieDTO);

    void delete(String movieId);

    void update(String movieId, MovieDTO movieDTO);

    List<MovieDTO> findAllByNameStartingWith(String startsWith);
}
