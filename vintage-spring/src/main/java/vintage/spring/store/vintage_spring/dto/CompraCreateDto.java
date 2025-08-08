package vintage.spring.store.vintage_spring.dto;


import jakarta.validation.constraints.NotNull;

public class CompraCreateDto {
    @NotNull
    private Long idCliente;

    @NotNull
    private Long idDisco;

    public CompraCreateDto() {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Long idDisco) {
        this.idDisco = idDisco;
    }
}
