package br.com.hinovamobile.motti.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;

import br.com.hinovamobile.motti.model.Evento;

public class SharedPreference {

    private Context mContext;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    public SharedPreference(Context mContext) {
        this.mContext = mContext;
        sharedPref = PreferenceManager.getDefaultSharedPreferences(mContext);
        editor = sharedPref.edit();
    }


    //criar metodo para salvar no share

    public void salvarEvento(Evento evento){
        editor.putString("eventoCadastrado", new Gson().toJson(evento));
        editor.commit();
    }

    public Evento recuperarEvento(){
        Evento eventoShared = new Evento();

        try{
            eventoShared = new Gson().fromJson(sharedPref.getString("eventoCadastrado", null), Evento.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return eventoShared;
    }

}
