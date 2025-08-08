package vintage.spring.store.vintage_spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ClienteUpdateDto {

    @NotNull
    private String nome;

    @NotNull
    @Email
    private String email;

    public ClienteUpdateDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
