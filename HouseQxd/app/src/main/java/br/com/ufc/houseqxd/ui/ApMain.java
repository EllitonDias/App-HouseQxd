package br.com.ufc.houseqxd.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.ufc.houseqxd.model.Apartamento;
import br.com.ufc.houseqxd.ApartamentoAdapter;
import br.com.ufc.houseqxd.dao.ApartamentoDAO;
import br.com.ufc.houseqxd.R;
import br.com.ufc.houseqxd.RecyclerApClick;

public class ApMain extends AppCompatActivity implements RecyclerApClick {
    private RecyclerView recyclerView;
    private ApartamentoAdapter adapter;
    private ApartamentoDAO dao = new ApartamentoDAO();
    private FloatingActionButton floatingActionButton, btnIr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ap_my);

        inicializacaoDosCampos();
        confingRecyclerView();
        confingBtnAdd();
        confingBtnAllAp();
    }

    private void confingBtnAllAp() {
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApMain.this, ApartamentoAll.class);
                startActivity(intent);
            }
        });
    }

    private void confingBtnAdd() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApMain.this, FormApartamento.class);
                startActivity(intent);
            }
        });
    }

    private void confingRecyclerView() {
        adapter = new ApartamentoAdapter(ApMain.this, dao.todos(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ApMain.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void inicializacaoDosCampos() {
        recyclerView = findViewById(R.id.recyclerViewAp);
        floatingActionButton = findViewById(R.id.add);
        btnIr = findViewById(R.id.ir);
    }

    @Override
    public void apClick(Apartamento apartamento) {
        Intent intent = new Intent(ApMain.this, InfoApartamento.class);
        intent.putExtra("apartamento",apartamento);
        startActivity(intent);
    }

    @Override
    public void LgClick(Apartamento apartamento) {
        dao.remover(apartamento);
        adapter.notifyDataSetChanged();
        Toast.makeText(ApMain.this,"Você apagou o apartamento: " + apartamento.getNome(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void btnEdit(int i,Apartamento apartamento) {
        Intent intent = new Intent(ApMain.this, EditApartamento.class);
        intent.putExtra("id",i);
        intent.putExtra("ap",apartamento);
        startActivity(intent);
    }
}