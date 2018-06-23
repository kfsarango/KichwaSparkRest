/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websparkrest;

import com.google.gson.Gson;

/**
 *
 * @author kfsarango1
 */
public class JsonUtil {
    public static String toJson(Object object) {
    return new Gson().toJson(object);
  }
 
  public static ResponseTransformer json() {
    return JsonUtil::toJson;
    
  }
}
