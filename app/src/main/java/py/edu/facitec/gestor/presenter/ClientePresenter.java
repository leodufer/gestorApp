package py.edu.facitec.gestor.presenter;

import java.util.List;

import py.edu.facitec.gestor.model.Cliente;
import py.edu.facitec.gestor.model.ClienteServicio;
import py.edu.facitec.gestor.view.ClienteView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by virux on 11/04/18.
 */

public class ClientePresenter {
    ClienteView clienteView;

    public ClientePresenter(ClienteView clienteView) {
        this.clienteView = clienteView;
    }

    public void obtenerCliente(){
        clienteView.showProgress();
        RestAdapter restAdapter = new RestAdapter.Builder()
                                    .setEndpoint("https://safe-forest.herokuapp.com")
                                    .build();

        ClienteServicio servicio = restAdapter.create(ClienteServicio.class);

        servicio.obtenerClientes(new Callback<List<Cliente>>() {
            @Override
            public void success(List<Cliente> clientes, Response response) {
                clienteView.goneProgress();
                clienteView.showClientes(clientes);
            }

            @Override
            public void failure(RetrofitError error) {
                clienteView.showError(error.getLocalizedMessage());
                clienteView.goneProgress();
            }
        });
    }
}
