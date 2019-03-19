package br.com.hinovamobile.motti.model;

import java.io.Serializable;

public class Evento implements Serializable {

    private String mNomeEvento;
    private String mEnderecoEvento;
    private String mTelefoneEvento;
    private String mDataEvento;

    public String getmDataEvento() {
        return mDataEvento;
    }

    public void setmDataEvento(String mDataEvento) {
        this.mDataEvento = mDataEvento;
    }

    public Evento(String mNomeEvento) {
        this.mNomeEvento = mNomeEvento;
    }

    public Evento() {

    }

    public String getmNomeEvento() {
        return mNomeEvento;
    }

    public void setmNomeEvento(String mNomeEvento) {
        this.mNomeEvento = mNomeEvento;
    }

    public String getmEnderecoEvento() {
        return mEnderecoEvento;
    }

    public void setmEnderecoEvento(String mEnderecoEvento) {
        this.mEnderecoEvento = mEnderecoEvento;
    }

    public String getmTelefoneEvento() {
        return mTelefoneEvento;
    }

    public void setmTelefoneEvento(String mTelefoneEvento) {
        this.mTelefoneEvento = mTelefoneEvento;
    }
}
