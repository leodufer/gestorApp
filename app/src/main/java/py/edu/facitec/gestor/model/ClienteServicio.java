package py.edu.facitec.gestor.model;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by virux on 11/04/18.
 */

public interface ClienteServicio {
    @GET("/clientes")
    void obtenerClientes(Callback<List<Cliente>> callback);
    @POST("/clientes")
    void guardarClient(@Body Cliente cliente, Callback<Cliente>callback);
}
