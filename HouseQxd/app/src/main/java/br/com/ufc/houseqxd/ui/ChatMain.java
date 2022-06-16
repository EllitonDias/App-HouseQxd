package br.com.ufc.houseqxd.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.ufc.houseqxd.MensagemAdapter;
import br.com.ufc.houseqxd.R;
import br.com.ufc.houseqxd.dao.MensagemDAO;
import br.com.ufc.houseqxd.model.Mensagem;

public class ChatMain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MensagemAdapter adapter;
    private MensagemDAO dao = new MensagemDAO();
    private ArrayList<Mensagem> mensagens;
    private FloatingActionButton btnEnviar;
    private EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);
        inicializacaoDosCampos();
        confingRecycler();


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ms = msg.getText().toString();
                if (ms.equals("")) {
                    Toast.makeText(ChatMain.this,"Digite a mensagem",Toast.LENGTH_SHORT).show();
                }else{
                    Mensagem mensagem = new Mensagem();
                    mensagem.setMsg(ms);
                    dao.salva(mensagem);
                    adapter.notifyDataSetChanged();
                    msg.setText("");
                }
            }
        });
    }

    private void inicializacaoDosCampos() {
        btnEnviar = findViewById(R.id.btn_enviar);
        msg = findViewById(R.id.mensagem);
    }

    private void confingRecycler() {
        recyclerView = findViewById(R.id.recyclerViewMsg);
        adapter = new MensagemAdapter(ChatMain.this, dao.todos());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ChatMain.this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}