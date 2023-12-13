package com.eliasfs06.gerenciadoreventos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eliasfs06.gerenciadoreventos.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table UserDetails(codigo TEXT primary key, nome TEXT, email TEXT, sexo TEXT, " +
                "rockInRio TEXT, theTown TEXT, lollapalooza TEXT, carnatal TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdatails");
    }

    public Boolean insertuserdata(Cliente cliente) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", cliente.getCodigo());
        contentValues.put("nome", cliente.getNome());
        contentValues.put("email", cliente.getEmail());
        contentValues.put("sexo", cliente.getSexo());
        contentValues.put("rockInRio", cliente.getRockInRio());
        contentValues.put("theTown", cliente.getTheTown());
        contentValues.put("lollapalooza", cliente.getLollapalooza());
        contentValues.put("carnatal", cliente.getCarnatal());
        long result = DB.insert("Userdetails", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean alterdata(Cliente cliente) {
        String codigoAntigo = cliente.getCodigo();
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", cliente.getCodigo());
        contentValues.put("nome", cliente.getNome());
        contentValues.put("email", cliente.getEmail());
        contentValues.put("sexo", cliente.getSexo());
        contentValues.put("rockInRio", cliente.getRockInRio());
        contentValues.put("theTown", cliente.getTheTown());
        contentValues.put("lollapalooza", cliente.getLollapalooza());
        contentValues.put("carnatal", cliente.getCarnatal());
        Cursor cursor = DB.rawQuery("Select * from Userdetails where codigo = ?", new String[]{codigoAntigo});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "codigo=?", new String[]{codigoAntigo});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }

    public Boolean deletedata(String codigo) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Userdetails WHERE codigo = ?", new String[]{codigo});

        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "codigo=?", new String[]{codigo});
            cursor.close();

            return result != -1;
        } else {
            cursor.close();
            return false;
        }
    }


    public boolean verificarClienteExistente(String codigo) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM Userdetails WHERE codigo = ?", new String[]{codigo});

        boolean existeCliente = cursor.getCount() > 0;

        cursor.close();
        return existeCliente;
    }

}
