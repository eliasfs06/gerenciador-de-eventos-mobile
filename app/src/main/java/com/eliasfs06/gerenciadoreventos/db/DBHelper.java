package com.eliasfs06.gerenciadoreventos.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eliasfs06.gerenciadoreventos.model.Evento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper dbHelperInstance;
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "EventosDB";
    private static final String TABLE_EVENTOS = "eventos";
    private static final String TABLE_INSCRITOS = "inscritos";
    private static final String KEY_CODIGO = "codigo";
    private static final String KEY_NOME = "nome";
    private static final String KEY_DESCRICAO = "descricao";
    private static final String KEY_DATA_INICIO = "dataInicio";
    private static final String KEY_DATA_FIM = "dataFim";
    private static final String KEY_EVENTO_CODIGO = "evento_codigo";
    private static final String KEY_INSCRITO = "inscrito";

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (dbHelperInstance == null) {
            dbHelperInstance = new DBHelper(context.getApplicationContext());
        }
        return dbHelperInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EVENTOS_TABLE = "CREATE TABLE " + TABLE_EVENTOS + "("
                + KEY_CODIGO + " TEXT PRIMARY KEY," + KEY_NOME + " TEXT,"
                + KEY_DESCRICAO + " TEXT," + KEY_DATA_INICIO + " TEXT,"
                + KEY_DATA_FIM + " TEXT" + ")";
        db.execSQL(CREATE_EVENTOS_TABLE);

        String CREATE_INSCRITOS_TABLE = "CREATE TABLE " + TABLE_INSCRITOS + "("
                + KEY_EVENTO_CODIGO + " TEXT,"
                + KEY_INSCRITO + " TEXT,"
                + "FOREIGN KEY(" + KEY_EVENTO_CODIGO + ") REFERENCES " + TABLE_EVENTOS + "(" + KEY_CODIGO + ")"
                + ")";
        db.execSQL(CREATE_INSCRITOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSCRITOS);
        onCreate(db);
    }

    public void addEvento(Evento evento) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CODIGO, evento.getCodigo());
        values.put(KEY_NOME, evento.getNome());
        values.put(KEY_DESCRICAO, evento.getDescricao());
        values.put(KEY_DATA_INICIO, evento.getDataInicio());
        values.put(KEY_DATA_FIM, evento.getDataFim());

        db.insert(TABLE_EVENTOS, null, values);

        // Salvar inscritos
        for (String inscrito : evento.getInscritos()) {
            ContentValues inscritoValues = new ContentValues();
            inscritoValues.put(KEY_EVENTO_CODIGO, evento.getCodigo());
            inscritoValues.put(KEY_INSCRITO, inscrito);
            db.insert(TABLE_INSCRITOS, null, inscritoValues);
        }

        db.close();
    }

    public Evento getEvento(String codigo) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EVENTOS, new String[]{KEY_CODIGO, KEY_NOME, KEY_DESCRICAO, KEY_DATA_INICIO, KEY_DATA_FIM},
                KEY_CODIGO + "=?", new String[]{codigo}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        if(cursor.getCount() == 0){
            return null;
        }

        List<String> inscritos = getInscritosDoEvento(db, codigo);
        Evento evento = new Evento(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), inscritos);

        cursor.close();
        return evento;
    }

    @SuppressLint("Range")
    private List<String> getInscritosDoEvento(SQLiteDatabase db, String codigoEvento) {
        List<String> inscritos = new ArrayList<>();

        Cursor cursor = db.query(TABLE_INSCRITOS, new String[]{KEY_INSCRITO},
                KEY_EVENTO_CODIGO + "=?", new String[]{codigoEvento}, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                inscritos.add(cursor.getString(cursor.getColumnIndex(KEY_INSCRITO)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return inscritos;
    }

    @SuppressLint("Range")
    public List<Evento> getAllEventos() {
        List<Evento> eventosList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EVENTOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String codigo = cursor.getString(cursor.getColumnIndex(KEY_CODIGO));
                String nome = cursor.getString(cursor.getColumnIndex(KEY_NOME));
                String descricao = cursor.getString(cursor.getColumnIndex(KEY_DESCRICAO));
                String dataInicio = cursor.getString(cursor.getColumnIndex(KEY_DATA_INICIO));
                String dataFim = cursor.getString(cursor.getColumnIndex(KEY_DATA_FIM));

                Evento evento = new Evento(codigo, nome, descricao, dataInicio, dataFim, new ArrayList<>());
                eventosList.add(evento);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return eventosList;
    }

    public void deleteEvento(String codigoEvento) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INSCRITOS, KEY_EVENTO_CODIGO + " = ?", new String[]{codigoEvento});
        db.delete(TABLE_EVENTOS, KEY_CODIGO + " = ?", new String[]{codigoEvento});

        db.close();
    }

}
