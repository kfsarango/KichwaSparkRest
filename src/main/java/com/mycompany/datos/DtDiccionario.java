/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kfsarango1
 */
public class DtDiccionario {
    Conexion con = new Conexion();

    public ResultSet getItems() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from items";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public ResultSet getItem(String wrd) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from items WHERE kichwa = '"+wrd+"' OR castellano = '"+wrd+"';";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
}
