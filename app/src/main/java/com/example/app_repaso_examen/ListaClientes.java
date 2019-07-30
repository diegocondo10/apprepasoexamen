package com.example.app_repaso_examen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.app_repaso_examen.listAdapters.ClienteAdapter;
import com.example.app_repaso_examen.models.ClienteBD;
import com.example.app_repaso_examen.models.ClienteMD;

import java.util.List;

public class ListaClientes extends AppCompatActivity {


    private ClienteAdapter clienteAdapter;
    private AlertDialog builder;
    //Variables de Componentes
    private ListView listaView;
    private ClienteMD cliente;

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

        clienteAdapter = new ClienteAdapter(this, R.layout.item_cli_list, listaClientes);
        listaView.setAdapter(clienteAdapter);


    }


    private void loader() {
        listaClientes = bd.selectAll();
        listaView = (ListView) findViewById(R.id.listCli);

        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                cliente = (ClienteMD) clienteAdapter.getItem(position);
                builder.show();

            }
        });
        builder = new AlertDialog.Builder(this)
                .setMessage("QUE DESEA HACER?")
                .setPositiveButton("EDITAR", (dialog, which) -> editar(cliente))
                .setNegativeButton("ELIMINAR", (dialog, which) -> eliminar(cliente))
                .create();

    }


    //EVENTOS
    private void editar(ClienteMD cliente) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("action", "update");
        intent.putExtra("identificacion", cliente.getIdentificacion());
        intent.putExtra("nombres", cliente.getNombres());
        intent.putExtra("apellidos", cliente.getApellidos());
        intent.putExtra("correo", cliente.getCorreo());
        intent.putExtra("sexo", cliente.getSexo());
        intent.putExtra("estadoCivil", cliente.getEstadoCivil());

        startActivity(intent);


    }

    private void eliminar(ClienteMD cliente) {
        bd.delete(cliente.getIdentificacion());

        Intent intent = new Intent(this, this.getClass());

        startActivity(intent);
    }




}
