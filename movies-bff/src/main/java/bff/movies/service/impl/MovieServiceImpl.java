package bff.movies.service.impl;

import bff.movies.dto.MovieDTO;
import bff.movies.repository.MovieRepository;
import bff.movies.service.MovieService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

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
