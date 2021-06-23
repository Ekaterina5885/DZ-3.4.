package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerRepositoryTest {

    private final MovieManagerRepository repository = new MovieManagerRepository();

    private final MovieList firstMovie = new MovieList(1, "MovieTitle-1", "thriller");
    private final MovieList secondMovie = new MovieList(2, "MovieTitle-2", "cartoon");
    private final MovieList thirdMovie = new MovieList(3, "MovieTitle-3", "comedy");
    private final MovieList fourthMovie = new MovieList(4, "MovieTitle-4", "thriller");
    private final MovieList fifthMovie = new MovieList(5, "MovieTitle-5", "horrors");
    private final MovieList sixthMovie = new MovieList(6, "MovieTitle-6", "cartoon");
    private final MovieList seventhMovie = new MovieList(7, "MovieTitle-7", "comedy");
    private final MovieList eighthMovie = new MovieList(8, "MovieTitle-8", "comedy");
    private final MovieList ninthMovie = new MovieList(9, "MovieTitle-9", "comedy");
    private final MovieList tenthMovie = new MovieList(10, "MovieTitle-10", "comedy");

    @BeforeEach
    public void input() {
        repository.save(firstMovie);
        repository.save(secondMovie);
        repository.save(thirdMovie);
        repository.save(fourthMovie);
        repository.save(fifthMovie);
        repository.save(sixthMovie);
        repository.save(seventhMovie);
        repository.save(eighthMovie);
        repository.save(ninthMovie);
        repository.save(tenthMovie);
    }

    // Возвращает массив всех хранящихся в массиве объектов;
    @Test
    public void shouldFindAll() {

        MovieList[] expected = new MovieList[]{firstMovie, secondMovie, thirdMovie, fourthMovie,
                fifthMovie, sixthMovie, seventhMovie, eighthMovie, ninthMovie, tenthMovie};
        MovieList[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    // Удаляет объект по идентификатору;
    @Test
    public void shouldRemoveById() {

        repository.removeById(5);

        MovieList[] expected = new MovieList[]{firstMovie, secondMovie, thirdMovie, fourthMovie,
                sixthMovie, seventhMovie, eighthMovie, ninthMovie, tenthMovie};
        MovieList[] actual = repository.getMovies();
        assertArrayEquals(expected, actual);

    }

    // Возвращает объект по идентификатору;
    @Test
    public void shouldFindById() {
        MovieList actual = repository.findById(5);
        MovieList expected = fifthMovie;
        assertEquals(expected, actual);
    }

    // Возвращаемый объект отсутствует;
    @Test
    public void shouldNotReturnObject() {
        MovieList actual = repository.findById(12);
        MovieList expected = null;
        assertEquals(expected, actual);
    }

    //  Полностью вычищает репозиторий;
    @Test
    public void shouldRemoveAll() {
        MovieList[] expected = new MovieList[0];
        MovieList[] actual = repository.removeAll();
    }
}