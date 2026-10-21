package br.uel.ex5API.service;


import br.uel.ex5API.model.Contact;
import br.uel.ex5API.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listarContatos() {
        return contactRepository.findAll();
    }

    public Contact buscarContato(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com id: " + id));
    }

    public Contact adicionarContato(Contact c) {
        return contactRepository.save(c);
    }

    // Opção 2 do slide: findById + map + orElseThrow
    public Contact atualizarContato(Long id, Contact contatoAtualizado) {
        return contactRepository.findById(id)
                .map(c -> {
                    c.setNome(contatoAtualizado.getNome());
                    c.setTelefone(contatoAtualizado.getTelefone());
                    c.setEmail(contatoAtualizado.getEmail());
                    c.setEndereco(contatoAtualizado.getEndereco());
                    c.setDataNascimento(contatoAtualizado.getDataNascimento());
                    return contactRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com id: " + id));
    }

    public void removerContato(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado com id: " + id);
        }
        contactRepository.deleteById(id);
    }
}