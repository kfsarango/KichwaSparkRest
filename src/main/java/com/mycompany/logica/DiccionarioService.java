/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.logica;

import com.mycompany.datos.DtDiccionario;
import com.mycompany.model.Item;
import com.mycompany.model.Multilenguaje;
import com.mycompany.model.Recurso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kfsarango1
 */
public class DiccionarioService {
    
    DtDiccionario dataDiccionario = new DtDiccionario();
    ArrayList<Item> ListItems = new ArrayList<>();

    public DiccionarioService() {
        RecuperarData();
    }
    
    
    
    public void RecuperarData() {
        try {
            
            ResultSet rs = dataDiccionario.getItems();
            while (rs.next()) {
                int id = rs.getInt("id");
                String kw = rs.getString("kichwa");
                String cs = rs.getString("castellano");
                
                Item myItem = new Item(id, kw,cs);
                
                ListItems.add(myItem);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiccionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Item> getDiccionario(){
        return this.ListItems;
    }
    
    public Item getItem(String key_word){
        Item myItem = null;
        try {
            
            ResultSet rs = dataDiccionario.getItem(key_word);
            while (rs.next()) {
                int id = rs.getInt("id");
                String kw = rs.getString("kichwa");
                String cs = rs.getString("castellano");
                
                myItem = new Item(id, kw,cs);
                
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiccionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myItem;
    }
    
    public ArrayList<Multilenguaje> RecuperarMultilenguaje() {
        ArrayList<Multilenguaje> myList = new ArrayList<>();
        String kw, en, es, sp, ca;
        Multilenguaje myDt;
        try {
            
            ResultSet rs = dataDiccionario.getDataMultilenguaje();
            while (rs.next()) {
                kw = rs.getString("kichwa");
                en = rs.getString("english");
                es = rs.getString("spanish");
                sp = rs.getString("speech");
                ca = rs.getString("category");
                
                myDt = new Multilenguaje(kw, en, es, sp, ca);
                
                myList.add(myDt);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiccionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myList;
    }
    
    public ArrayList<Recurso> RecuperarInfoWordNet() {
        ArrayList<Recurso> myList = new ArrayList<>();
        int id;
        String sbj, pre, obj, tra;
        Recurso myDt;
        try {
            
            ResultSet rs = dataDiccionario.getDataWordNet();
            while (rs.next()) {
                id = rs.getInt("id");
                sbj = rs.getString("subject");
                pre = rs.getString("predicate");
                obj = rs.getString("object");
                tra = rs.getString("translate");

                myDt = new Recurso(id, sbj, pre, obj,tra);
                
                myList.add(myDt);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiccionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myList;
    }
    
    public Multilenguaje RecuperarItemMultilenguaje(String word) {
        String kw, en, es, sp, ca;
        Multilenguaje myDt = null;
        try {
            
            ResultSet rs = dataDiccionario.getItemMultilenguaje(word);
            while (rs.next()) {
                kw = rs.getString("kichwa");
                en = rs.getString("english");
                es = rs.getString("spanish");
                sp = rs.getString("speech");
                ca = rs.getString("category");
                
                myDt = new Multilenguaje(kw, en, es, sp, ca);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiccionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myDt;
    }
    
    public void guardarData(Recurso myRecurso){
        dataDiccionario.insertInfoWordnet(myRecurso.getSubject(), myRecurso.getPredicate(), myRecurso.getObject());
    }
    
    public void añadirTraduccion(Recurso myRecurso){
        System.out.println("id = " +  myRecurso.getId() +  " translate: " +myRecurso.getTranslate());
        dataDiccionario.updateToAddTranslate(myRecurso.getId(), myRecurso.getTranslate());
    }
    
    public Recurso comprobarExistenciaRecurso(String word){
        String s, p, o, t;
        int id;
        Recurso myRecurso = null;
        try {
            
            ResultSet rs = dataDiccionario.getSubjectToComprobation(word);
            while (rs.next()) {
                id = rs.getInt("id");
                s = rs.getString("subject");
                p = rs.getString("predicate");
                o = rs.getString("object");
                t = rs.getString("translate");
                
                myRecurso = new Recurso(id, s, p, o,t);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DiccionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return myRecurso;
    }
    
    
    
    
    
    
    
}
