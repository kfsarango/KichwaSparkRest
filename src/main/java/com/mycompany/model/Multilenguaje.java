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
public class Multilenguaje {
    public String kichwa;
    public String espanish;
    public String english;
    public String speech;
    public String category;

    public Multilenguaje(String kichwa, String english,String espanish, String speech, String category) {
        this.kichwa = kichwa;
        this.espanish = espanish;
        this.english = english;
        this.speech = speech;
        this.category = category;
    }

    public String getKichwa() {
        return kichwa;
    }

    public void setKichwa(String kichwa) {
        this.kichwa = kichwa;
    }

    public String getEspanish() {
        return espanish;
    }

    public void setEspanish(String espanish) {
        this.espanish = espanish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
