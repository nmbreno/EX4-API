package br.uel.ex4API.controller;

import br.uel.ex4API.model.Contact;
import br.uel.ex4API.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContactController {
    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Contact>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{index}")
    public ResponseEntity<?> buscar(@PathVariable int index) {

        try {
            Contact c = service.buscar(index);
            return ResponseEntity.ok(c);
        }
        catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Contact c) {

        try {
            service.adicionar(c);
            return ResponseEntity.status(HttpStatus.CREATED).body(c);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<?> remover(@PathVariable int index) {

        try {
            service.remover(index);
            return ResponseEntity.noContent().build();
        }
        catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> atualizar (@PathVariable int index, @RequestBody Contact c) {

        try {
            service.atualizar(index, c);
            return ResponseEntity.ok(c);
        }
        catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
