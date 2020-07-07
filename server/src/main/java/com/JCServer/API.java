package com.JCServer;
import com.JCServer.model.Ordonnance;
import com.JCServer.model.Patient;
import com.JCServer.model.RendezVous;
import com.JCServer.model.User;
import com.JCServer.service.AuthService;
import com.JCServer.service.OrdonnaceService;
import com.JCServer.service.PatientService;
import com.JCServer.service.RenderVousService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import spark.Spark;

import static  spark.Spark.*;
public class API {
    static PatientService patientservice =new PatientService();
    static  RenderVousService rendervousservice=new RenderVousService();
    static OrdonnaceService ordonnaceservice= new OrdonnaceService();
    static AuthService authservice=new AuthService();
    public static <e> void main(String[] args) {
        Gson gson = new Gson();

            port(8080);

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
                response.header("Access-Control-Allow-Origin","*");

            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

            post("/add-patient", (req, res) -> {
                res.header("Access-Control-Allow-Origin", "*");

                res.type("application/json");
                System.out.println(req.body());
                Patient P = gson.fromJson(req.body(), Patient.class);
                return patientservice.AddPatient(P);

            }, gson::toJson);

        delete("/delete-patient", (req, res) -> {
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            System.out.println(req.body());
            Patient P = gson.fromJson(req.body(), Patient.class);
            return patientservice.DeletePaitent(P.getId());
        }, gson::toJson);


        get("/get-patients", (req, res) -> {
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            Patient P = gson.fromJson(req.body(), Patient.class);
            return patientservice.GetAllPatients();

            }, gson::toJson);

        put("/update-patient",(req,res)->{
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            Patient P = gson.fromJson(req.body(), Patient.class);
            return  patientservice.UpdatePaitent(P.getId(),P);

        },gson::toJson);



    //RenderVous RequestHandlers


    post("/add-rendervous", (req, res) -> {
        res.header("Access-Control-Allow-Headers","*");
        res.header("Access-Control-Allow-Methods","*");
        res.header("Access-Control-Allow-Origin","*");
        res.type("application/json");
        System.out.println(req.body());
        RendezVous R = gson.fromJson(req.body(), RendezVous.class);
        return rendervousservice.AddRenderVous(R);

    }, gson::toJson);

    delete("/delete-rendervous", (req, res) -> {
        res.header("Access-Control-Allow-Headers","*");
        res.header("Access-Control-Allow-Methods","*");
        res.header("Access-Control-Allow-Origin","*");
        res.type("application/json");
        System.out.println(req.body());
        RendezVous R = gson.fromJson(req.body(), RendezVous.class);
        return rendervousservice.DeleteRenderVous(R.getId());
    }, gson::toJson);


    get("/get-rendervous", (req, res) -> {
        res.header("Access-Control-Allow-Headers","*");
        res.header("Access-Control-Allow-Methods","*");
        res.header("Access-Control-Allow-Origin","*");
        res.type("application/json");
        RendezVous R = gson.fromJson(req.body(), RendezVous.class);
        return rendervousservice.GetAllRenderVous();

    }, gson::toJson);

    put("/update-rendervous",(req,res)->{
        res.header("Access-Control-Allow-Headers","*");
        res.header("Access-Control-Allow-Methods","*");
        res.header("Access-Control-Allow-Origin","*");
        res.type("application/json");
        RendezVous R = gson.fromJson(req.body(), RendezVous.class);
        return  rendervousservice.UpdateRenderVous(R.getId(),R);

    },gson::toJson);



    //Ordonnance Request Handler


        post("/add-ordonnance", (req, res) -> {
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            System.out.println(req.body());
            Ordonnance O = gson.fromJson(req.body(), Ordonnance.class);
            return ordonnaceservice.AddOrdonnance(O);

        }, gson::toJson);

        delete("/delete-ordonnance", (req, res) -> {
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            System.out.println(req.body());
            Ordonnance O = gson.fromJson(req.body(), Ordonnance.class);
            return ordonnaceservice.DeleteOrdonnance(O.getId());
        }, gson::toJson);


        get("/get-ordonnance", (req, res) -> {
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            Ordonnance O = gson.fromJson(req.body(), Ordonnance.class);
            return ordonnaceservice.GetAllOrdonnance() ;

        }, gson::toJson);

        put("/update-ordonnance",(req,res)->{
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            Ordonnance O = gson.fromJson(req.body(), Ordonnance.class);
            return  ordonnaceservice.UpdateOrdonnance(O.getId(),O);

        },gson::toJson);


        //authentication


        post("/login", (req, res) -> {
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            System.out.println(req.body());
            User U = gson.fromJson(req.body(), User.class);
            return authservice.Login(U);

        }, gson::toJson);


        post("/signup", (req, res) -> {
            res.header("Access-Control-Allow-Headers","*");
            res.header("Access-Control-Allow-Methods","*");
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            System.out.println(req.body());
            User U = gson.fromJson(req.body(), User.class);
            return authservice.Singup(U);

        }, gson::toJson);


    }



}
