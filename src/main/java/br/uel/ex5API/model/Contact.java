package br.uel.ex5API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "contatos")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    @Column(nullable = false, unique = true, length = 20)
    private String telefone;

    @Email(message = "O e-mail deve ser válido")
    @NotBlank(message = "O e-mail é obrigatório")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Size(max = 200, message = "O endereço deve ter no máximo 200 caracteres")
    @Column(length = 200)
    private String endereco;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;


    //CONSTRUTORES
    public Contact() {}

    public Contact (String nome, String telefone, String email, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;

    }

    //GETTERS
    public Long getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
