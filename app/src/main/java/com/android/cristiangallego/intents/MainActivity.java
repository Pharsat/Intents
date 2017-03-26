package com.android.cristiangallego.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends Activity {

    private Usuario usuarioObtenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null && parametros.containsKey(getResources().getString(R.string.parametroUsuario))) {

            usuarioObtenido = (Usuario)parametros.get(getResources().getString(R.string.parametroUsuario));

            ((EditText) findViewById(R.id.txtNombre)).setText(usuarioObtenido.getNombre());
            ((EditText) findViewById(R.id.txtDescripcion)).setText(usuarioObtenido.getDescripcion());
            ((EditText) findViewById(R.id.txtEmail)).setText(usuarioObtenido.getEmail());
            ((EditText) findViewById(R.id.txtTelefono)).setText(usuarioObtenido.getTelefono());
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
        user.setNombre(((EditText) findViewById(R.id.txtNombre)).getText().toString());
        user.setTelefono(((EditText) findViewById(R.id.txtTelefono)).getText().toString());
        user.setDescripcion(((EditText) findViewById(R.id.txtDescripcion)).getText().toString());
        user.setEmail(((EditText) findViewById(R.id.txtEmail)).getText().toString());
        DatePicker fechaDeNacimiento = ((DatePicker) findViewById(R.id.dpFechaNac));
        user.setFechaNac(new DateTime(fechaDeNacimiento.getDayOfMonth(), fechaDeNacimiento.getMonth(), fechaDeNacimiento.getYear()));
        return user;
    }
}
