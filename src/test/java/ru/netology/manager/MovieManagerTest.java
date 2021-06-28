package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieList;
import ru.netology.repository.MovieManagerRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieManagerRepository repository;
    @InjectMocks
    private MovieManager manager;
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

    // Выдать 10 фильмов в ленту;
    @Test
    public void shouldFindAll() {
        MovieList[] returned = new MovieList[]{firstMovie, secondMovie, thirdMovie, fourthMovie, fifthMovie,
                sixthMovie, seventhMovie, eighthMovie, ninthMovie, tenthMovie};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{tenthMovie, ninthMovie, eighthMovie, seventhMovie,
                sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }

    // Выдать 9 фильмов в ленту;
    @Test
    public void getMoviesToLimitValue() {
        MovieList[] returned = new MovieList[]{firstMovie, secondMovie, thirdMovie, fourthMovie, fifthMovie,
                sixthMovie, seventhMovie, eighthMovie, ninthMovie};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{ninthMovie, eighthMovie, seventhMovie, sixthMovie,
                fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }

    // Выдать фильмы в ленту выше граничного значения;
    @Test
    public void getMoviesAboveLimitValue() {
        MovieList[] returned = new MovieList[]{firstMovie, secondMovie, thirdMovie, fourthMovie, fifthMovie,
                sixthMovie, seventhMovie, eighthMovie, ninthMovie, tenthMovie};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{tenthMovie, ninthMovie, eighthMovie, seventhMovie,
                sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }

    // Возвращает 0 фильмов;
    @Test
    public void shouldFindZeroMovies() {
        MovieList[] returned = new MovieList[]{};
        doReturn(returned).when(repository).findAll();

        MovieList[] expected = new MovieList[]{};
        MovieList[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }
}











