package py.edu.facitec.gestor.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import py.edu.facitec.gestor.R;
import py.edu.facitec.gestor.model.Cliente;
import py.edu.facitec.gestor.presenter.AgregarClientePresenter;


public class AgregarClienteActivity extends AppCompatActivity implements ClienteView {

    EditText nombreEditText;
    EditText correoEditText;
    ProgressBar progressBar;
    AgregarClientePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cliente);
        nombreEditText = (EditText) findViewById(R.id.editTextNombre);
        correoEditText = (EditText) findViewById(R.id.editTextCorreo);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        presenter = new AgregarClientePresenter(this);
    }

    public void guardarCliente(View view) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombreEditText.getText().toString());
        cliente.setCorreo(correoEditText.getText().toString());
        if(validar(cliente)){
            presenter.guardarCliente(cliente);
        }

    }

    private boolean validar(Cliente cliente){
        if(cliente.getNombre().isEmpty()){
            nombreEditText.setError("Complete el nombre del cliente");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(cliente.getCorreo()).matches()){
            correoEditText.setError("Complete un correo valido");
            return false;
        }

        return true;
    }

    @Override
    public void showClientes(List<Cliente> clientes) {
        //No implementar;
    }

    @Override
    public void showError(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void goneProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void showSuccess() {
        Toast.makeText(getApplicationContext(),"Cliente Registrado",Toast.LENGTH_SHORT).show();
        finish();
    }
}
