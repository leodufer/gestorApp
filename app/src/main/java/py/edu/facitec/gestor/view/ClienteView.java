package py.edu.facitec.gestor.view;

import java.util.List;

import py.edu.facitec.gestor.model.Cliente;

/**
 * Created by virux on 11/04/18.
 */

public interface ClienteView {
    void showClientes(List<Cliente> clientes);
    void showError(String mensaje);
    void showProgress();
    void goneProgress();
    void showEmptyState();

}
