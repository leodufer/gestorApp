package py.edu.facitec.gestor.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import py.edu.facitec.gestor.R;
import py.edu.facitec.gestor.model.Cliente;

/**
 * Created by virux on 18/04/18.
 */

public class ClienteAdapter extends BaseAdapter {

    private List<Cliente> clientes;
    private Context context;

    public ClienteAdapter(List<Cliente> clientes, Context context) {
        this.clientes = clientes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return clientes.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_cliente,null);
        }
        Cliente  cliente = clientes.get(i);

        TextView nombreTextView = (TextView) view.findViewById(R.id.textViewNombre);
        TextView emailTextView = view.findViewById(R.id.textViewEmail);


        nombreTextView.setText(cliente.getNombre());
        emailTextView.setText(cliente.getCorreo());


        return view;
    }
}
