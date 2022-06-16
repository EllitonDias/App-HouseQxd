package br.com.ufc.houseqxd.dao;

import java.util.ArrayList;

import br.com.ufc.houseqxd.model.Apartamento;

public class ApartamentoDAO {
    private final static ArrayList<Apartamento> apartamentos = new ArrayList<>();



    public void salva(Apartamento apartamento) {
        apartamentos.add(apartamento);
    }

    public void remover(Apartamento apartamento){
        apartamentos.remove(apartamento);
    }

    public void editar(int id,Apartamento apartamento){
        apartamentos.set(id,apartamento);
    }

    public ArrayList<Apartamento> todos() {
        return apartamentos;
    }

}
