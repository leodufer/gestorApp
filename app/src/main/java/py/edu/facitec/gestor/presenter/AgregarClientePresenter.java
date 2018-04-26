package py.edu.facitec.gestor.presenter;

import py.edu.facitec.gestor.model.Cliente;
import py.edu.facitec.gestor.model.ClienteServicio;
import py.edu.facitec.gestor.view.ClienteView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by virux on 25/04/18.
 */

public class AgregarClientePresenter {

    ClienteView view;
    ClienteServicio servicio;

    public AgregarClientePresenter(ClienteView view) {
        this.view = view;
        RestAdapter restAdapter = new RestAdapter
                                            .Builder()
                                            .setEndpoint("https://safe-forest.herokuapp.com")
                                            .build();
        servicio = restAdapter.create(ClienteServicio.class);
    }

    public void guardarCliente(Cliente cliente){
        view.showProgress();
        servicio.guardarClient(cliente, new Callback<Cliente>() {
            @Override
            public void success(Cliente cliente, Response response) {
                view.showSuccess();
                view.goneProgress();
            }

            @Override
            public void failure(RetrofitError error) {
                view.showError(error.getLocalizedMessage());
                view.goneProgress();
            }
        });
    }
}
