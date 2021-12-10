package com.example.alarmavf.modelos;

public class Usuario {
    int id;
    String usuario;

    public boolean isNull(){
        if(usuario.equals("")){
            return false;
        }

        return true;
    }

    public Usuario(){

    }

    public Usuario(int id, String usuario) {
        this.id = id;
        this.usuario= usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
