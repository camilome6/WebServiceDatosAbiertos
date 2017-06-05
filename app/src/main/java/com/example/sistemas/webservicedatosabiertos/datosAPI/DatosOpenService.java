package com.example.sistemas.webservicedatosabiertos.datosAPI;

import com.example.sistemas.webservicedatosabiertos.models.Acueducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 22/05/17.
 */

public interface DatosOpenService {

    @GET("tsnt-i8ug.json")
    Call<List<Acueducto>> obtenerListaAcueductos();
}
