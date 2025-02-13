package vttp.batch5.paf.movies.exceptions;

import org.bson.Document;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vttp.batch5.paf.movies.models.errors.SqlBatchInsertException;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(SqlBatchInsertException.class)
    public void handleInsertFail(SqlBatchInsertException ex, HttpServletRequest req, HttpServletResponse ResponseEntity) {
       
        // Document doc = new Document();
        // doc.append("imdb_ids", ids);
        // doc.append("error", ex.getMessage());
        // doc.append("timestamp", new Date());

        
  
        
    }
}
