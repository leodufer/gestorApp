package py.edu.facitec.gestor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import py.edu.facitec.gestor.model.Cliente;
import py.edu.facitec.gestor.presenter.ClientePresenter;
import py.edu.facitec.gestor.view.ClienteView;

public class MainActivity extends AppCompatActivity implements ClienteView{
    TextView resultTextView;
    ClientePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.textResult);
        presenter=new ClientePresenter(this);
        presenter.obtenerCliente();

    }

    @Override
    public void showClientes(List<Cliente> clientes) {
        resultTextView.setText(clientes.toString());
    }

    @Override
    public void showError(String mensaje) {
        resultTextView.setText(mensaje);
    }
}
