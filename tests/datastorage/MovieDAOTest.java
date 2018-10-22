package datastorage;

import domain.CastMember;
import domain.Movie;
import domain.MovieCollection;
import domain.Show;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieDAOTest extends DAO {
    MovieCollection movieCollection;
    Movie movie;
    int movieId = 2;
    MovieDAO movieDAO;

    @BeforeEach
    void setUp() {
        movieDAO = new MovieDAO();
    }

    @AfterEach
    void tearDown() {
        movieDAO = null;
    }

    @Test
    void getActualMovies() {
        movieCollection = movieDAO.getActualMovies();
        assertNotNull(movieCollection);
    }

    @Test
    void find() {
        movie = movieDAO.find(movieId);
        assertEquals("Mission Impossible", movie.getTitle());
    }

    @Test
    void getCastMembers() {
        List<CastMember> castMembers;
        movie = movieDAO.find(movieId);
        castMembers = movie.getCastMembers();
        assertNotNull(castMembers);
    }

    @Test
    void getShows() {
        HashMap<String, ArrayList<Show>> shows;
        movie = movieDAO.find(movieId);
        shows = movie.getShows();
        assertNotNull(shows);
        assertNotNull(shows.values());
    }
}