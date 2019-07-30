package com.example.app_repaso_examen.listAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_repaso_examen.R;
import com.example.app_repaso_examen.models.ClienteMD;

import java.util.List;

public class ClienteAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ClienteMD> lista;

    public ClienteAdapter(Context context, int layout, List<ClienteMD> lista) {
        this.context = context;
        this.layout = layout;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.item_cli_list, null);

        TextView txtIdent = (TextView) view.findViewById(R.id.textIdentificacion);
        TextView txtNomb = (TextView) view.findViewById(R.id.textNombres);
        TextView txtApe = (TextView) view.findViewById(R.id.texApellidos);

        txtIdent.setText(lista.get(position).getIdentificacion());
        txtNomb.setText(lista.get(position).getNombres());
        txtApe.setText(lista.get(position).getApellidos());


        return view;
    }
}
