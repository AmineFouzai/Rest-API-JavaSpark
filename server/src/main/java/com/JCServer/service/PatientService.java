package com.JCServer.service;

import com.JCServer.model.Patient;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    MongoClientURI uri = new MongoClientURI(System.getenv("MONGO_URI"));

    MongoClient mongoClient = new MongoClient(uri);


    public String AddPatient(Patient P) {
        Document doc = new Document();
        doc.put("FirstName", P.getFirstName());
        doc.put("LastName", P.getLastName());
        doc.put("DateOfBirth", P.getDateOfBirth());
        doc.put("PhoneNumber", P.getPhoneNumber());
        doc.put("ReservationState", P.getReservationState());
        mongoClient.getDatabase("Hospital").getCollection("Patients").insertOne(doc);
        return doc.toJson();
    }

    public List<String> GetAllPatients() {
        Gson gson = new Gson();
        ArrayList<String> liste = new ArrayList<>();
        FindIterable<Document> docs = mongoClient.getDatabase("Hospital").getCollection("Patients").find();
        for (Document doc : docs) {
            liste.add(doc.toJson());

        }
        return liste;
    }

    public String DeletePaitent(String _id) {
        Document doc = mongoClient.getDatabase("Hospital").getCollection("Patients").findOneAndDelete(
                new Document("_id", new ObjectId(_id))
        );
        return doc.toJson();
    }

    public String UpdatePaitent(String _id, Patient P) {
        MongoDatabase database = mongoClient.getDatabase("Hospital");
        MongoCollection coll=database.getCollection("Patients");
        Document found= (Document) coll.find(new Document("_id",new ObjectId(_id))).first();
        Bson ToUpdate= new Document("FirstName",P.getFirstName()).append("LastName",P.getLastName()).append("DateOfBirth",P.getDateOfBirth()).append("PhoneNumber",P.getPhoneNumber()).append("ReservationState",P.getReservationState());
        Bson UpdateOperation= new Document("$set",ToUpdate);
        coll.updateOne(found,UpdateOperation);
        System.out.println(found.toJson());
        return found.toJson() ;
   }
}
