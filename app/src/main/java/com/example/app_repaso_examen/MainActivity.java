package com.example.app_repaso_examen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.app_repaso_examen.models.ClienteBD;
import com.example.app_repaso_examen.models.ClienteMD;

public class MainActivity extends AppCompatActivity {

    //Variables de componentes
    private TextView textForm;
    private EditText edtTextIndentificacion;
    private EditText edtTextNombres;
    private EditText edtTextApellidos;
    private EditText edtTextCorreo;
    private RadioGroup radioGroup;
    private Spinner spEstCivil;
    private Button btnGuardar;
    private Button btnVerClientes;

    //Varaibles de datos
    private ClienteMD clienteMD;
    private ClienteBD bd;

    private String action = "";
    private String pk;

    {
        bd = new ClienteBD(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            action = extras.get("action").toString();
        }

        loader();


        cargarSpinner();

        textForm.setText("INGRESO DE CLIENTES");


    }


    //METODOS DE APOYO

    private ClienteMD getCliente() throws NullPointerException {
        String identificacion = edtTextIndentificacion.getText().toString();
        String nombres = edtTextNombres.getText().toString();
        String apellidos = edtTextApellidos.getText().toString();
        String correo = edtTextCorreo.getText().toString();

        String sexo = (
                (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())
        ).getText().toString();

        String estCivil = spEstCivil.getSelectedItem().toString();

        clienteMD = new ClienteMD();
        clienteMD.setIdentificacion(identificacion);
        clienteMD.setNombres(nombres);
        clienteMD.setApellidos(apellidos);
        clienteMD.setCorreo(correo);
        clienteMD.setSexo(sexo);
        clienteMD.setEstadoCivil(estCivil);
        return clienteMD;
    }


    private void loader() {

        textForm = (TextView) findViewById(R.id.textForm);

        edtTextIndentificacion = (EditText) findViewById(R.id.edtTextIdentificacion);
        edtTextNombres = (EditText) findViewById(R.id.edtTextNombres);
        edtTextApellidos = (EditText) findViewById(R.id.edtTextApellidos);
        edtTextCorreo = (EditText) findViewById(R.id.edtTextCorreo);

        radioGroup = (RadioGroup) findViewById(R.id.radGsexo);
        spEstCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnVerClientes = (Button) findViewById(R.id.btnVerClientes);


        if (action.equals("update")) {
            btnGuardar.setOnClickListener(e -> btnUpdate());
            pk = getIntent().getStringExtra("identificacion");
            setForm();
        } else {
            btnGuardar.setOnClickListener(e -> btnInsertar());
        }


        btnVerClientes.setOnClickListener(e -> btnVerClientes());

    }


    private void cargarSpinner() {

        ArrayAdapter<CharSequence> estCivil = ArrayAdapter.createFromResource(this, R.array.arrayEstCivil, android.R.layout.simple_spinner_item);

        estCivil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spEstCivil.setAdapter(estCivil);


    }

    private void resetForm() {

        edtTextIndentificacion.setText("");
        edtTextNombres.setText("");
        edtTextApellidos.setText("");
        edtTextCorreo.setText("");
        spEstCivil.setSelection(0);

    }

    private void setForm() {
        edtTextIndentificacion.setText(getIntent().getStringExtra("identificacion"));
        edtTextNombres.setText(getIntent().getStringExtra("nombres"));
        edtTextApellidos.setText(getIntent().getStringExtra("apellidos"));
        edtTextCorreo.setText(getIntent().getStringExtra("correo"));

    }

    private void errorMSG(String message) {
        AlertDialog builder = new AlertDialog.Builder(this)
                .setMessage(message)
                .setTitle("ERROR")
                .setPositiveButton("OK", null)
                .create();
        builder.show();
    }


    //EVENTOS

    private void btnInsertar() {
        try {

            if (bd.insert(getCliente())) {
                btnVerClientes();
                resetForm();
            } else {
                errorMSG("HA OCURRIDO UN ERROR CONTACTE CON EL ADMIN");
            }

        } catch (NullPointerException e) {
            errorMSG("RELLENE CORRECTAMENTE EL FORMULARIO");
        }


    }

    private void btnUpdate() {
        try {

            if (bd.update(getCliente(), pk)) {
                btnVerClientes();
                resetForm();
            } else {
                errorMSG("HA OCURRIDO UN ERROR CONTACTE CON EL ADMIN");
            }

        } catch (NullPointerException e) {
            errorMSG("RELLENE CORRECTAMENTE EL FORMULARIO");
        }
    }

    private void btnVerClientes() {
        Intent intent = new Intent(this, ListaClientes.class);
        startActivity(intent);
    }


}
