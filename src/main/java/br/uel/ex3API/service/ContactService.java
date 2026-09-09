package br.uel.ex3API.service;


import br.uel.ex3API.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private List<Contact> contatos = new ArrayList<>();

    public Contact buscar(int index) {
        return contatos.get(index);
    }


    public void adicionar(Contact c) {
        contatos.add(c);
    }

    public void remover(int index) {
        contatos.remove(index);
    }

    public void atualizar(int index, Contact c) {
        contatos.set(index, c);
    }

    public List<Contact> listar() {
        return contatos;
    }

}
