/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websparkrest;

import com.google.gson.Gson;
import com.mycompany.logica.DiccionarioService;
import com.mycompany.model.Recurso;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author kfsarango1
 */
public class ServicioRestKichwa {

    public static void main(String[] args) {
        DiccionarioService usDiccionario = new DiccionarioService();
        // Para insertar datos de WordNet
        post("/recurso", (request, response) -> {
            response.type("application/json");
            Recurso data = new Gson().fromJson(request.body(), Recurso.class);
            usDiccionario.guardarData(data);

            return new Gson()
              .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        
        // Para añadir traducción a la información de wordnet
        post("/addtranslate", (request, response) -> {
            response.type("application/json");
            Recurso data = new Gson().fromJson(request.body(), Recurso.class);
            usDiccionario.añadirTraduccion(data);

            return new Gson()
              .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        
        
        get("/diccionario", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(usDiccionario.getDiccionario())));
        });

        get("/diccionario/:word", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(usDiccionario.getItem(request.params(":word")))));
        });

        get("/multilenguaje", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(usDiccionario.RecuperarMultilenguaje())));
        });
        
        get("/wordnet", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(usDiccionario.RecuperarInfoWordNet())));
        });

        get("/multilenguaje/:word", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(usDiccionario.RecuperarItemMultilenguaje(request.params(":word")))));
        });
        
        //Para comprobar la existencia de un SUbject
        get("/comprobar/:word", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson()
                            .toJsonTree(usDiccionario.comprobarExistenciaRecurso(request.params(":word")))));
        });

        

    }

}
