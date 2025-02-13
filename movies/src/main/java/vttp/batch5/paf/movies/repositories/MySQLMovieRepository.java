package vttp.batch5.paf.movies.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.Movie;

@Repository
public class MySQLMovieRepository {

  @Autowired
  private JdbcTemplate template;

    private static final String SQL_TABLE_EMPTY = "select count(*) from imdb";
    private static final String SQL_BATCH_INSERT = "insert into imdb values (?,?,?,?,?,?,?)";
    private static final String SQL_CREATE_INDEX = "create index directors on imdb";
    private static final String SQL_GET_DIRECTORS = "";

    public Boolean isTableEmpty() {
      
      Integer count = template.queryForObject(SQL_TABLE_EMPTY, Integer.class);
      
      return  count == null || count == 0;
    }

    // TODO: Task 2.3
    // You can add any number of parameters and return any type from the method
    public Boolean batchInsertMovies(List<Movie> movies)  {


      List<Object[]> params = movies.stream()
        .map(m -> new Object[]{
          m.getImdbId(), 
          m.getVoteAverage(),
          m.getVoteCount(),
          m.getReleaseDate(),
          m.getRevenue(),
          m.getBudget(),
          m.getRuntime()
        }).collect(Collectors.toList());

      int[] added = template.batchUpdate(SQL_BATCH_INSERT,params);
            
      return added.length > 0 ;
    }
    
    // TODO: Task 3
    public List<Movie> getMovies() {
      return null;
    }

    


}
