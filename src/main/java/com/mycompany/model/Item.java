/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

/**
 *
 * @author kfsarango1
 */
public class Item {
    private int id;
    private String kichwa;
    private String castellano;

    public Item(int id, String kichwa, String castellano) {
        this.id = id;
        this.kichwa = kichwa;
        this.castellano = castellano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKichwa() {
        return kichwa;
    }

    public void setKichwa(String kichwa) {
        this.kichwa = kichwa;
    }

    public String getCastellano() {
        return castellano;
    }

    public void setCastellano(String castellano) {
        this.castellano = castellano;
    }


    
}
