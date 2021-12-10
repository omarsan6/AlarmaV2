package com.example.alarmavf.controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alarmavf.modelos.Usuario;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="AlarmaPM2";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, usuario text)";

    public daoUsuario(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertUsuario(Usuario u){
        if(buscar(u.getUsuario())==0){
            ContentValues cv = new ContentValues();
            cv.put("usuario",u.getUsuario());
            return (sql.insert("usuario",null,cv)>0);
        } else{
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista=selectUsuario();
        for (Usuario us: lista){
            if(us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuario(){
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                lista.add(u);
            }while(cr.moveToNext());
        }

        return  lista;
    }

    public int login(String u){
        int a=0;
        Cursor cr = sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u)){
                    a++;
                }
            }while(cr.moveToNext());
        }

        return a;
    }

    public Usuario getUsuario(String u){
        lista=selectUsuario();
        for (Usuario uss:lista){
            if(uss.getUsuario().equals(u)){
                return uss;

            }
        }
        return null;
    }

    public Usuario getUsuarioByID(int id){
        lista=selectUsuario();
        for (Usuario uss:lista){
            if(uss.getId()==id){
                return uss;

            }
        }
        return null;
    }


}
