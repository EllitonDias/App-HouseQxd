package br.com.ufc.houseqxd;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MensagemViewHolder extends RecyclerView.ViewHolder {
    TextView msg;
    public MensagemViewHolder(@NonNull View itemView) {
        super(itemView);
        msg = itemView.findViewById(R.id.mensagem);
    }
}
