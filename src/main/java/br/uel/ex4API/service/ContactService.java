package br.uel.ex4API.service;


import br.uel.ex4API.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private List<Contact> contatos = new ArrayList<>();

    private void validar(Contact c) {
        if (c == null
                || c.getNome() == null || c.getNome().isBlank()
                || c.getTelefone() == null || c.getTelefone().isBlank()
                || c.getEmail() == null || c.getEmail().isBlank()) {

                throw new IllegalArgumentException("Nome, telefone e e-mail são obrigatórios. ");
            }
    }

    private void validarIndex(int index) {
        if (index < 0 || index >= contatos.size()) {
            throw new IndexOutOfBoundsException("Contato não encontrado no índice " + index);
        }
    }

    public Contact buscar(int index) {
        validarIndex(index);
        return contatos.get(index);
    }


    public void adicionar(Contact c) {
        validar(c);
        contatos.add(c);
    }

    public void remover(int index) {
        validarIndex(index);
        contatos.remove(index);
    }

    public void atualizar(int index, Contact c) {
        validarIndex(index);
        validar(c);
        contatos.set(index, c);
    }

    public List<Contact> listar() {
        return contatos;
    }

}
