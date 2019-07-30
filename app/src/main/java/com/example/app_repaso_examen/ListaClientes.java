package com.example.app_repaso_examen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.app_repaso_examen.listAdapters.ClienteAdapter;
import com.example.app_repaso_examen.models.ClienteBD;
import com.example.app_repaso_examen.models.ClienteMD;

import java.util.List;

public class ListaClientes extends AppCompatActivity {


    //Variables de Componentes
    private ListView listaView;


    //Variables de Datos
    private List<ClienteMD> listaClientes;
    private ClienteBD bd;

    {
        bd = new ClienteBD(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);

        loader();

        ClienteAdapter clienteAdapter = new ClienteAdapter(this, R.layout.item_cli_list, listaClientes);
        listaView.setAdapter(clienteAdapter);


    }


    private void loader() {
        listaClientes = bd.selectAll();
        listaView = (ListView) findViewById(R.id.listCli);
    }


}
