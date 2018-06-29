/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.logica;

import com.mycompany.datos.DtDiccionario;
import com.mycompany.model.Item;
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
    
    
    
    
    
}
