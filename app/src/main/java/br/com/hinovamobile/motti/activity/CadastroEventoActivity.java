package br.com.hinovamobile.motti.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.hinovamobile.motti.R;
import br.com.hinovamobile.motti.data.SharedPreference;
import br.com.hinovamobile.motti.model.Evento;

public class CadastroEventoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText mNomeEvento;
    private TextInputEditText mEnderecoEvento;
    private TextInputEditText mTelefoneEvento;
//    private TextInputEditText mDataEvento;



    private Button mCadastrar;
    private Evento evento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        try{
            mNomeEvento = findViewById(R.id.mNomeEvento);
            mEnderecoEvento = findViewById(R.id.mEnderecoEvento);
            mTelefoneEvento = findViewById(R.id.mTelefoneEvento);
         //   mDataEvento = findViewById(R.id.mDataEvento);
            mCadastrar  = findViewById(R.id.mCadastrar);

            mCadastrar.setOnClickListener(this);
            //fazer os findview dos elementos na tela
//        mNomeEvento
//          mEnderecoEvento

//        TextInputEditText mNomeEvento = view.findViewById(R.id.mNomeEvento);
//        TextInputEditText mEnderecoEvento = view.findViewById(R.id.mEnderecoEvento);

            //no seu butao
//        mCadastrar.setOnClickListener(this);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }



    private void cadastrarEvento(){
        evento = new Evento();
        evento.setmNomeEvento(mNomeEvento.getText().toString());
        evento.setmEnderecoEvento(mEnderecoEvento.getText().toString());
        evento.setmTelefoneEvento(mTelefoneEvento.getText().toString());
     ///   evento.setmDataEvento(mDataEvento.getText().toString());
        Toast.makeText(this, evento.getmNomeEvento(), Toast.LENGTH_LONG).show();

        Intent returnIntent = new Intent();
        returnIntent.putExtra("resultEvento",evento);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.mCadastrar){

            //validar se todos os campos foram informados.
            cadastrarEvento();
        }
    }
}
