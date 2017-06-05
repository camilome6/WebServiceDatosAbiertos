package com.example.sistemas.webservicedatosabiertos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.sistemas.webservicedatosabiertos.datosAPI.DatosOpenService;
import com.example.sistemas.webservicedatosabiertos.models.Acueducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    public final static String TAG = "ACUEDUCTO";
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private ListaAutoAdapter listaAutoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaAutoAdapter = new ListaAcueductoAdapter(this);
        recyclerView.setAdapter(listaAutoAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerLista();
                        }
                    }
                }
            }
        });
    }

    private void obtenerDatosAcueducto() {
        DatosOpenService service = retrofit.create(DatosOpenService.class);
        Call<List<Acueducto>> acueductoRespuestaCall = service.obtenerListaAcueductos();

        acueductoRespuestaCall.enqueue(new Callback<List<Acueducto>>() {
            @Override
            public void onResponse(Call<List<Acueducto>> call, Response<List<Acueducto>> response) {
                if(response.isSuccessful()){
                    List lista = response.body();

                    for(int i=0;i<lista.size();i++)
                    {
                        Acueducto p = (Acueducto) lista.get(i);
                        Log.i(TAG," barrio: "+p.getBarrio()+" armaempleada: "+p.getArmaEmpleada());
                    }

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Acueducto>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }


}
