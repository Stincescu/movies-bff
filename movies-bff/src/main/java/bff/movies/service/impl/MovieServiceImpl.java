package bff.movies.service.impl;

import bff.movies.dto.MovieDTO;
import bff.movies.repository.MovieRepository;
import bff.movies.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieRepository movieRepository;
    @Override
    public List<MovieDTO> getAll() {
        //TODO: Add business logic to all methods from here
        return movieRepository.getAlL();
    }

    @Override
    public MovieDTO getById(String id) {
        return movieRepository.getById(id);
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        return movieRepository.create(movieDTO);
    }

    @Override
    public void delete(String movieId) {
        movieRepository.delete(movieId);
    }

    @Override
    public void update(String movieId, MovieDTO movieDTO) {
        movieRepository.update(movieId, movieDTO);
    }

    @Override
    public List<MovieDTO> search(String startsWith) {
        return movieRepository.findAllByNameStartingWith(startsWith);

    }
}
