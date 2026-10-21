package br.uel.ex5API.controller;

import br.uel.ex5API.model.Contact;
import br.uel.ex5API.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> listar() {
        return ResponseEntity.ok(contactService.listarContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> buscar(@PathVariable Long id) {
        try {
            Contact c = contactService.buscarContato(id);
            return ResponseEntity.ok(c);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contact> adicionar(@Valid @RequestBody Contact c) {
        Contact salvo = contactService.adicionarContato(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            contactService.removerContato(id);
            return ResponseEntity.ok("Contato removido com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Contact contatoAtualizado) {
        try {
            Contact atualizado = contactService.atualizarContato(id, contatoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
