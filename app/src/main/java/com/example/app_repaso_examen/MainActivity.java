package com.example.app_repaso_examen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textForm;
    EditText edtTextIndentificacion;
    EditText edtTextNombres;
    EditText edtTextApellidos;
    EditText edtTextCorreo;

    RadioGroup radioGroup;
    RadioButton radSexo;

    Spinner spEstCivil;
    Button btnGuardar;
    Button btnVerClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


    }

    private void cargarSpinner() {

    }


}
