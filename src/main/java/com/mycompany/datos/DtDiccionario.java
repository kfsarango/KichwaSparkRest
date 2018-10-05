/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kfsarango1
 */
public class DtDiccionario {

    Conexion con = new Conexion();
    Connection myConnection;

    public DtDiccionario() {
        try {
            this.myConnection = con.AbrirConexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DtDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getItems() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from items";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet getDataMultilenguaje() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from multilenguaje";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet getDataWordNet() throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from recursos";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet getItem(String wrd) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from items WHERE kichwa = '" + wrd + "' OR castellano = '" + wrd + "';";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet getItemMultilenguaje(String wrd) throws ClassNotFoundException, SQLException {
        Statement st = con.AbrirConexion().createStatement();
        String Sentencia = "select * from multilenguaje WHERE kichwa = '" + wrd + "';";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet getSubjectToComprobation(String wrd) throws ClassNotFoundException, SQLException {
        Statement st = myConnection.createStatement();
        String Sentencia = "select * from recursos WHERE subject = '" + wrd + "';";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet insertInfoWordnet(String s, String p, String o) {
        ResultSet rs = null;
        try {
            //agregando caracteres de escape
            o = o.replaceAll("'", "\\\\'");
            String sentencia = "insert into recursos(subject, predicate, object)"
                    + "values('" + s + "','" + p + "','" + o + "');";

            PreparedStatement statement = myConnection.prepareStatement(sentencia,
                    Statement.RETURN_GENERATED_KEYS);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo guardar");
            }

            rs = statement.getGeneratedKeys();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return rs;
    }

    public int updateToAddTranslate(int id, String translate) {
        Statement st;
        int rs = 0;
        try {
            st = myConnection.createStatement();

            String sentencia = "update recursos set translate = '" + translate + "' WHERE id = " + id + ";";
            
            PreparedStatement preEnviar = myConnection.prepareStatement(sentencia);
            
            rs =  preEnviar.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DtDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
