package vttp.batch5.paf.movies.models.errors;

public class SqlBatchInsertException extends RuntimeException{

    public SqlBatchInsertException() {
    }

    public SqlBatchInsertException(String message) {
        super(message);
    }

    public SqlBatchInsertException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
