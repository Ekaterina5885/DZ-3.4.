package ru.netology.repository;

import ru.netology.domain.MovieList;

public class MovieManagerRepository {

    private MovieList[] movies = new MovieList[0];

// Возвращает массив всех хранящихся в массиве объектов;

    public MovieList[] findAll() {
        return movies;
    }

// Добавляет объект в массив;

    public void save(MovieList item) {
        int length = movies.length + 1;
        MovieList[] tmp = new MovieList[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

// Возвращает объект по идентификатору;

    public MovieList findById(int id) {
        for (MovieList movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

// Удаляет объект по идентификатору;

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieList[] tmp = new MovieList[length];
        int index = 0;
        for (MovieList movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
    }

//  Полностью вычищает репозиторий;

    public MovieList[] removeAll() {
        MovieList[] tmp = new MovieList[0];
        return tmp;
    }
}
