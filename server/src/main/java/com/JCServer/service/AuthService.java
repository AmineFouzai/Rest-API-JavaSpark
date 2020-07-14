package com.JCServer.service;

import com.JCServer.model.User;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;

public class AuthService {

    MongoClientURI uri = new MongoClientURI(System.getenv("MONGO_URI"));

    MongoClient mongoClient = new MongoClient(uri);


    public  String Login(User U){
        try {
            MongoDatabase database = mongoClient.getDatabase("Hospital");
            MongoCollection coll = database.getCollection("Users");
            Document found = (Document) coll.find(new Document("Email", U.getEmail()).append("Password", U.getPassword())).first();
            System.out.println(found.toString());
            if (found != null) {
                return found.toJson();
            }
        }catch (Exception e){
            return  "false";
        }
        return  "false";
    }

    public String Singup(User U){
        Document doc = new Document();
        doc.put("UserName", U.getUsername());
        doc.put("Email", U.getEmail());
        doc.put("Password", U.getPassword());
        mongoClient.getDatabase("Hospital").getCollection("Users").insertOne(doc);
        return doc.toJson();



    }

}
