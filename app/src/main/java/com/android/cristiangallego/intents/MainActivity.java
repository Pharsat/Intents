package com.android.cristiangallego.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Usuario usuarioObtenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null && parametros.containsKey(getResources().getString(R.string.parametroUsuario))) {

            usuarioObtenido = (Usuario)parametros.get(getResources().getString(R.string.parametroUsuario));

            ((TextInputEditText) findViewById(R.id.txtNombre)).setText(usuarioObtenido.getNombre());
            ((TextInputEditText) findViewById(R.id.txtDescripcion)).setText(usuarioObtenido.getDescripcion());
            ((TextInputEditText) findViewById(R.id.txtEmail)).setText(usuarioObtenido.getEmail());
            ((TextInputEditText) findViewById(R.id.txtTelefono)).setText(usuarioObtenido.getTelefono());
            ((DatePicker) findViewById(R.id.dpFechaNac)).updateDate(usuarioObtenido.getFechaNac().getYear(),usuarioObtenido.getFechaNac().getMonth(),usuarioObtenido.getFechaNac().getDay());

        }

    }

    protected void btnSiguiente_Clic(View v) {
        Intent pantallaConfirmacion = new Intent(MainActivity.this, Confirmacion.class);
        pantallaConfirmacion.putExtra(getResources().getString( R.string.parametroUsuario), leerUsuario());
        startActivity(pantallaConfirmacion);
        finish();
    }

    private Usuario leerUsuario() {
        Usuario user = new Usuario();
        user.setNombre(((TextInputEditText) findViewById(R.id.txtNombre)).getText().toString());
        user.setTelefono(((TextInputEditText) findViewById(R.id.txtTelefono)).getText().toString());
        user.setDescripcion(((TextInputEditText) findViewById(R.id.txtDescripcion)).getText().toString());
        user.setEmail(((TextInputEditText) findViewById(R.id.txtEmail)).getText().toString());
        DatePicker fechaDeNacimiento = ((DatePicker) findViewById(R.id.dpFechaNac));
        user.setFechaNac(new DateTime(fechaDeNacimiento.getDayOfMonth(), fechaDeNacimiento.getMonth(), fechaDeNacimiento.getYear()));
        return user;
    }
}
