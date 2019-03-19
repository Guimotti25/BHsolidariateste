package br.com.hinovamobile.motti.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.hinovamobile.motti.R;
import br.com.hinovamobile.motti.adapter.EventoAdapter;
import br.com.hinovamobile.motti.model.Evento;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int COD_EVENTO = 10;

    private List<Evento> eventoList;
    private RecyclerView mRecyclerView;
    private EventoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eventoList = new ArrayList<>();

        //Aqui vc pega seu float
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        //Vc configura o seu recyclerview para  exibir o seus cards
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);



//        Evento evento = new Evento();
//        evento.setNome("Teste");
//        evento.setEndereco("Endereco Teste");
//        evento.setAtivo(true);
//        eventoList.add(evento);
//        Evento evento1 = new Evento();
//        evento1.setNome("Teste");
//        evento1.setEndereco("Endereco Teste");
//        evento1.setAtivo(true);
//        eventoList.add(evento1);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new EventoAdapter(this,eventoList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == COD_EVENTO){

            if(Activity.RESULT_OK == resultCode){
                if (data.hasExtra("resultEvento")){
                    Evento evento = (Evento) data.getSerializableExtra("resultEvento");
                    eventoList = new ArrayList<>();
                    eventoList.add(evento);
                    mAdapter.uptadeEventoAdapter(eventoList);

                    //
                }
            }


        }
    }

    @Override
    public void onClick(View view) {

        //Aqui vc faz sua funcao de chamar tela de cadastro
        if(view.getId() == R.id.fab){

            //Aqui e provisorio
            try{
                Intent intent = new Intent(this, CadastroEventoActivity.class);
                startActivityForResult(intent,COD_EVENTO);
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
//            Evento evento1 = new Evento();
//            evento1.setmNomeEvento("Solidáriza-se BH");
//            evento1.setmEnderecoEvento("Hospital da Baleia ");
//            evento1.setmTelefoneEvento("99678-9876");
         //   evento1.setImagemEvento("");


//            eventoList = new ArrayList<>();
//            eventoList.add(evento1);
//            mAdapter.uptadeEventoAdapter(eventoList);

        }

    }
}
