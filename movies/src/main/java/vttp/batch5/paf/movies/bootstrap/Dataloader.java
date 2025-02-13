package vttp.batch5.paf.movies.bootstrap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.services.MovieService;

@Component
public class Dataloader implements CommandLineRunner {

  @Autowired
  private MovieService mSvc;

  //TODO: Task 2
  @Override
  public void run(String...args) {
    
    System.out.println("reading...");
    try {

      if (mSvc.isSqlTableEmpty()==true) {
        
          FileInputStream fis = new FileInputStream("../Data/movies_post_2010.zip");
          BufferedInputStream bis = new BufferedInputStream(fis);
          ZipInputStream zis = new ZipInputStream(bis);
          ZipEntry entry;
          
          entry =  zis.getNextEntry();

          InputStreamReader isr= new InputStreamReader(zis);
          BufferedReader br = new BufferedReader(isr);
          String line ="";

          List<Movie> movies = new ArrayList<>();
          //List<MovieDetails> mds = new ArrayList<>();
          List<Document> docs = new ArrayList<>();
          
          while(entry != null && (! "movie_post_2010.json".equals(entry.getName())) && (null != (line = br.readLine()))) {
            JsonReader reader = Json.createReader(new StringReader(line));
            JsonObject data = reader.readObject();
            String releaseDate = data.getString("release_date");
    
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date release_date = df.parse(releaseDate);
            Date dDate = df.parse("2017-12-31");
            
            if (release_date.after(dDate)) {
              //import
              Movie m = new Movie();
              m.setImdbId(data.getString("imdb_id",""));
              m.setVoteAverage(Float.valueOf(data.getInt("vote_average",0)));
              m.setVoteCount(data.getInt("vote_count",0));
              m.setReleaseDate(df.parse(data.getString("release_date")));
              m.setRevenue(Float.valueOf(data.getInt("revenue",0)));
              m.setBudget(Float.valueOf(data.getInt("budget",0)));
              m.setRuntime(data.getInt("runtime",0));

              Document doc = new Document();
              doc.append("imdb_id", data.getString("imdb_id",""));
              doc.append("title",data.getString("title",""));
              doc.append("directors",data.getString("director",""));
              doc.append("overview",data.getString("overview",""));
              doc.append("tagline",data.getString("tagline",""));
              doc.append("genres",data.getString("genres",""));
              doc.append("imdb_rating",data.getInt("imdb_rating",0));
              doc.append("imdb_votes",data.getInt("imdb_votes",0));

              movies.add(m);
              //mds.add(md);
              docs.add(doc);  
            }
          }
      
        
        br.close();
        System.out.println("inserting");
        List<String> ids = mSvc.insertToDbs(movies, docs);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    
    
    

      
      
      
    
  }

}

                
                //System.out.println(m);
                // MovieDetails md = new MovieDetails();
                // md.setImdbId(data.getString("imdb_id",""));
                // md.setTitle(data.getString("title",""));
                // md.setDirectors(data.getString("directors",""));
                // md.setOverview(data.getString("overview",""));
                // md.setTagline(data.getString("tagline",""));
                // md.setGenres(data.getString("genres",""));
                // md.setImdbRating(data.getInt("imdb_rating",0));
                // md.setImdbVotes(data.getInt("imdb_votes",0));
