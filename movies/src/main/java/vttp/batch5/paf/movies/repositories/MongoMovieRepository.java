package vttp.batch5.paf.movies.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class MongoMovieRepository {

    @Autowired
    private MongoTemplate template;


 // TODO: Task 2.3
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //  
 // db.imdb.insertMany([
 //     {}, {},...
 // ])
 //
 public List<String> batchInsertMovies(List<Document> list) {
    Collection<Document> newDocs = template.insert(list, "imdb");

    List<String> ids = new ArrayList<>();
    newDocs.forEach(doc -> {
        ObjectId oid = doc.getObjectId("_id");
        ids.add(oid.toString());
    });
    return ids;
 }

 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public String logError(Document error) {
    Document newDoc = template.insert(error, "errors");
    ObjectId oid = newDoc.getObjectId("_id");
    
    return oid.toString();
 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //


}
