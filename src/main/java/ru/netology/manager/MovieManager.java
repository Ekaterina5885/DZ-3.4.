package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieList;
import ru.netology.repository.MovieManagerRepository;


@NoArgsConstructor
@Data

public class MovieManager {
    private MovieManagerRepository repository;
    private int quantityMovies = 10;

    public MovieManager(int quantityMovies) {
        this.quantityMovies = quantityMovies;
    }

    public MovieManager(MovieManagerRepository repo) {
        repository = repo;
    }

    // Добавляет объект в массив;
    public void add(MovieList movie) {
        repository.save(movie);
    }

    // Получает массив всех хранящихся в массиве объектов;
    public MovieList[] getAll() {
        MovieList[] movies = repository.findAll();
        MovieList[] result = new MovieList[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    // Удаляет объект по идентификатору;
    public void removeById(int id) {
        repository.removeById(id);
    }

    //  Полностью вычищает репозиторий;
    public void removeAll(int i) {
        repository.removeAll();
    }

}






