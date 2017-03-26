package com.android.cristiangallego.intents;

import java.io.Serializable;

/**
 * Created by USUARIO on 26/03/2017.
 */

public class Usuario implements Serializable {
    private String Nombre;
    private String Telefono;
    private DateTime FechaNac;
    private String Email;
    private String Descripcion;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public DateTime getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(DateTime fechaNac) {
        FechaNac = fechaNac;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
