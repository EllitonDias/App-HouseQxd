package br.com.ufc.houseqxd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.ufc.houseqxd.model.Mensagem;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemViewHolder> {
    private Context context;
    private ArrayList<Mensagem> mensagens;

    public MensagemAdapter(Context context, ArrayList<Mensagem> mensagens) {
        this.context = context;
        this.mensagens = mensagens;
    }

    @NonNull
    @Override
    public MensagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mensagem_chat,parent,false);
        MensagemViewHolder mensagemViewHolder = new MensagemViewHolder(view);
        return mensagemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MensagemViewHolder mensagemViewHolder, int position) {
        Mensagem msg = mensagens.get(position);
        mensagemViewHolder.msg.setText(msg.getMsg());
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }
}
