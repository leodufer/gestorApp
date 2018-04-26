package py.edu.facitec.gestor;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import py.edu.facitec.gestor.model.Cliente;
import py.edu.facitec.gestor.presenter.ClientePresenter;
import py.edu.facitec.gestor.view.AgregarClienteActivity;
import py.edu.facitec.gestor.view.ClienteAdapter;
import py.edu.facitec.gestor.view.ClienteView;

public class MainActivity extends AppCompatActivity implements ClienteView{
    TextView resultTextView;
    ClientePresenter presenter;
    ListView clientesListView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.textResult);
        clientesListView = findViewById(R.id.listView_clientes);
        progressBar = findViewById(R.id.progressBar);

        presenter=new ClientePresenter(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.obtenerCliente();
    }

    @Override
    public void showClientes(List<Cliente> clientes) {
        ClienteAdapter adapter = new ClienteAdapter(clientes,this);
        clientesListView.setAdapter(adapter);
        clientesListView.setVisibility(View.VISIBLE);
        resultTextView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String mensaje) {
        resultTextView.setText(mensaje);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        clientesListView.setVisibility(View.GONE);
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

    }

    public void agregarCliente(View view){
        Intent intent = new Intent(MainActivity.this, AgregarClienteActivity.class);
        startActivity(intent);
    }
}
