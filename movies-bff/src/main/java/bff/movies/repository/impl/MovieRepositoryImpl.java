package bff.movies.repository.impl;

import bff.movies.dto.MovieDTO;
import bff.movies.repository.MovieRepository;
import bff.movies.repository.data.MovieProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Override
    public List<MovieDTO> getAlL() {
        return MovieProvider.getAll();
    }

    @Override
    public MovieDTO getById(String id) {
        return MovieProvider.getById(id);
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        return MovieProvider.create(movieDTO);
    }

    @Override
    public void delete(String movieId) {
        MovieProvider.delete(movieId);
    }

    @Override
    public void update(String movieId, MovieDTO movieDTO){
        MovieProvider.update(movieId, movieDTO);
    }

    @Override
    public List<MovieDTO> findAllByNameStartingWith(String startsWith) {
        return MovieProvider.findAllByNameStartingWith(startsWith);
    }
}
