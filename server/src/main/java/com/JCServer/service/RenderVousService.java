package com.JCServer.service;

import com.JCServer.model.Patient;
import com.JCServer.model.RendezVous;
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

public class RenderVousService {

    MongoClientURI uri = new MongoClientURI("mongodb+srv://john:qMzQeo2yMAfRyrqQ@dolphineducation-vovf3.mongodb.net/Hospital?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);


    public String AddRenderVous(RendezVous R) {
        Document doc = new Document();
        doc.put("FirstName", R.getFirstName());
        doc.put("LastName", R.getLastName());
        doc.put("Date", R.getDate());
        doc.put("Time", R.getTime());
        doc.put("ReservationState", R.getReservationState());
        mongoClient.getDatabase("Hospital").getCollection("RenderVous").insertOne(doc);
        return doc.toJson();
    }

    public List<String> GetAllRenderVous() {
        Gson gson = new Gson();
        ArrayList<String> liste = new ArrayList<>();
        FindIterable<Document> docs = mongoClient.getDatabase("Hospital").getCollection("RenderVous").find();
        for (Document doc : docs) {
            liste.add(doc.toJson());
        }
        return liste;
    }

    public String DeleteRenderVous(String _id) {
        Document doc = mongoClient.getDatabase("Hospital").getCollection("RenderVous").findOneAndDelete(
                new Document("_id", new ObjectId(_id))
        );
        return doc.toJson();
    }

    public String UpdateRenderVous(String _id, RendezVous R) {
        MongoDatabase database = mongoClient.getDatabase("Hospital");
        MongoCollection coll=database.getCollection("RenderVous");
        Document found= (Document) coll.find(new Document("_id",new ObjectId(_id))).first();
        Bson ToUpdate= new Document("FirstName",R.getFirstName()).append("LastName",R.getLastName()).append("Date",R.getDate()).append("Time",R.getTime()).append("ReservationState",R.getReservationState());
        Bson UpdateOperation= new Document("$set",ToUpdate);
        coll.updateOne(found,UpdateOperation);
        System.out.println(found.toJson());
        return found.toJson() ;
    }
}
