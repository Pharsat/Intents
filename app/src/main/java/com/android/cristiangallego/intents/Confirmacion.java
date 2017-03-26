package com.android.cristiangallego.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmacion extends Activity {

    private Usuario usuarioObtenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle parametros = getIntent().getExtras();
        usuarioObtenido = (Usuario) parametros.get(getResources().getString(R.string.parametroUsuario));

        ((TextView) findViewById(R.id.lblNombre)).setText(usuarioObtenido.getNombre());
        ((TextView) findViewById(R.id.lblDescripcion)).setText(usuarioObtenido.getDescripcion());
        ((TextView) findViewById(R.id.lblEmail)).setText(usuarioObtenido.getEmail());
        ((TextView) findViewById(R.id.lblTelefono)).setText(usuarioObtenido.getTelefono());
        ((TextView) findViewById(R.id.lblFechaNac)).setText(usuarioObtenido.getFechaNac().toString());
    }

    protected void btnEditarDatos_Clic(View v) {
        Intent pantallaConfirmacion = new Intent(Confirmacion.this, MainActivity.class);
        pantallaConfirmacion.putExtra(getResources().getString(R.string.parametroUsuario), usuarioObtenido);
        startActivity(pantallaConfirmacion);
        finish();
    }

}
