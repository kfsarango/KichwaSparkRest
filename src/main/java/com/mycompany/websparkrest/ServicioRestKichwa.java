/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websparkrest;

import com.google.gson.Gson;
import com.mycompany.logica.DiccionarioService;
import static spark.Spark.get;

/**
 *
 * @author kfsarango1
 */
public class ServicioRestKichwa {
    
    public static void main(String[] args) {
        DiccionarioService usDiccionario = new DiccionarioService();

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
    }

}
