package br.com.ufc.houseqxd.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.houseqxd.model.Mensagem;

public class MensagemDAO {
    private final static ArrayList<Mensagem> mensagens = new ArrayList<>();

    public void salva(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

    public ArrayList<Mensagem> todos() {
        return mensagens;
    }
}
