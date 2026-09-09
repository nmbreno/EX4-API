package br.uel.ex3API.controller;

import br.uel.ex3API.model.Contact;
import br.uel.ex3API.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContactController {
    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) { this.service = service; }

    @GetMapping
    public List<Contact> listar() {
        return service.listar();
    }

    @GetMapping("/{index}")
    public Contact buscar(@PathVariable int index) {
        return service.buscar(index);
    }

    @PostMapping
    public void adicionar(@RequestBody Contact c) {
        service.adicionar(c);
    }

    @DeleteMapping("/{index}")
    public void remover(@PathVariable int index) {
        service.remover(index);
    }

    @PutMapping("/{index}")
    public void atualizar (@PathVariable int index, @RequestBody Contact c) {
        service.atualizar(index, c);
    }
}
