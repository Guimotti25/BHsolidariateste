package br.com.hinovamobile.motti.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.hinovamobile.motti.R;
import br.com.hinovamobile.motti.model.Evento;

public class EventoAdapter  extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder>{

    private Context mContext;
    private List<Evento> eventos;

    public EventoAdapter(@NonNull Context context, @NonNull List<Evento> eventos) {
        this.mContext = context;
        this.eventos = eventos;
    }

    public void uptadeEventoAdapter(List<Evento> datas)
    {
        List<Evento> aux = new ArrayList<>();
        if(datas == null || datas.size()==0)
            return;
        if (eventos != null && eventos.size()>0)
            aux.addAll(eventos);
        eventos = new ArrayList<>();
        eventos.addAll(datas);
        eventos.addAll(aux);
        notifyDataSetChanged();

        //antes vc tem que pegar a lista anterior

    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_evento, viewGroup, false);
        EventoViewHolder viewHolder = new EventoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder eventoViewHolder, int i) {

        Evento evento = eventos.get(i);
        eventoViewHolder.mNomeEvento.setText(evento.getmNomeEvento());
        eventoViewHolder.mEndereco.setText(evento.getmEnderecoEvento());
        eventoViewHolder.mTelefone.setText(evento.getmTelefoneEvento());
     //   eventoViewHolder.mDataEvento.setText(evento.getmDataEvento());


    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public static class EventoViewHolder extends RecyclerView.ViewHolder{

        private TextView mNomeEvento;
        private TextView mEndereco;
        private TextView mTelefone;
      //  private TextView mDataEvento;

        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mNomeEvento = itemView.findViewById(R.id.txtNomeEvento);
            this.mEndereco = itemView.findViewById(R.id.txtEnderecoEvento);
            this.mTelefone = itemView.findViewById(R.id.txtTelefone);
        //    this.mDataEvento = itemView.findViewById(R.id.mDataEvento);
        }
    }

}
