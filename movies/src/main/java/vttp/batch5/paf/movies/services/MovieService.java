package vttp.batch5.paf.movies.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;

@Service
public class MovieService {

  @Autowired
  private MongoMovieRepository mongoRepo;

  @Autowired
  private MySQLMovieRepository sqlRepo;

  // TODO: Task 2
  public Boolean isSqlTableEmpty() {
    return sqlRepo.isTableEmpty();
  }

  public void insertError(Document error) {
    mongoRepo.logError(error);
  }
  
  public List<String> insertToDbs(List<Movie> movies, List<Document> docs) {
    List<Movie> temp = new ArrayList<>();
    List<Document> tempDoc = new ArrayList<>();
    List<String> ids = new ArrayList<>();
    List<String> imdbIds = new ArrayList<>();
     
    while(!movies.isEmpty()) {
        
        for (int i=0; i<25; i++) {
          
          temp.add(movies.get(i));
          movies.remove(i);
          tempDoc.add(docs.get(i));
          docs.remove(i);
          
          if (i == 24) {

            if (sqlRepo.batchInsertMovies(temp) == true) {
              temp.clear();
              tempDoc.clear();
            } else if (sqlRepo.batchInsertMovies(temp) == false) {
              temp.forEach(m -> {
                ids.add(m.getImdbId());
              });
              return ids;
            }
          }
          ids.addAll(mongoRepo.batchInsertMovies(tempDoc));

          if ((movies.indexOf(movies.get(i))+1) > (movies.size())) {
            break;
          }
        }
        
      }
      System.out.println(ids);
    return ids;
  }

  public Document toError(List<String> ids, Exception ex) {
    Document doc = new Document();
    doc.append("imdb_ids", ids);
    doc.append("error", ex.getMessage());
    doc.append("timestamp", new Date());

    return doc;
  }



  // TODO: Task 3
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void getProlificDirectors() {
  }


  // TODO: Task 4
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void generatePDFReport() {

  }

}
