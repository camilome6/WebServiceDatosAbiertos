package com.example.sistemas.webservicedatosabiertos.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sistemas on 22/05/17.
 */

public class Acueducto {

    @SerializedName("barrio")
    @Expose
    private String barrio;

    @SerializedName("arma_empleada")
    @Expose
    private String armaEmpleada;




    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }



    public String getArmaEmpleada() {
        return armaEmpleada;
    }

    public void setArmaEmpleada(String armaEmpleada) {
        this.armaEmpleada = armaEmpleada;
    }



}



