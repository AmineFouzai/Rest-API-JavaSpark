package com.JCServer.service;

import com.JCServer.model.Ordonnance;
import com.JCServer.model.Patient;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class OrdonnaceService {


    MongoClientURI uri = new MongoClientURI("mongodb+srv://john:qMzQeo2yMAfRyrqQ@dolphineducation-vovf3.mongodb.net/Hospital?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);


    public String AddOrdonnance(Ordonnance O) {
        Document doc = new Document();
        doc.put("FirstName", O.getFirstName());
        doc.put("LastName", O.getLastName());
        doc.put("Description", O.getDescription());
        doc.put("Date", O.getDate());
        mongoClient.getDatabase("Hospital").getCollection("Ordonnance").insertOne(doc);
        return doc.toJson();
    }

    public List<String> GetAllOrdonnance() {
        Gson gson = new Gson();
        ArrayList<String> liste = new ArrayList<>();
        FindIterable<Document> docs = mongoClient.getDatabase("Hospital").getCollection("Ordonnance").find();
        for (Document doc : docs) {
            liste.add(doc.toJson());

        }
        return liste;
    }

    public String DeleteOrdonnance(String _id) {
        Document doc = mongoClient.getDatabase("Hospital").getCollection("Ordonnance").findOneAndDelete(
                new Document("_id", new ObjectId(_id))
        );
        return doc.toJson();
    }

    public String UpdateOrdonnance(String _id, Ordonnance O) {
        MongoDatabase database = mongoClient.getDatabase("Hospital");
        MongoCollection coll=database.getCollection("Ordonnance");
        Document found= (Document) coll.find(new Document("_id",new ObjectId(_id))).first();
        Bson ToUpdate= new Document("FirstName",O.getFirstName()).append("LastName",O.getLastName()).append("Description",O.getDescription()).append("Date",O.getDate());
        Bson UpdateOperation= new Document("$set",ToUpdate);
        coll.updateOne(found,UpdateOperation);
        System.out.println(found.toJson());
        return found.toJson() ;
    }
}
