package vintage.spring.store.vintage_spring.dto;

import jakarta.validation.constraints.NotNull;

public class DiscoUpdateDto {
    @NotNull
    private String titulo;
    @NotNull
    private String artista;
    @NotNull
    private Double preco;

    public DiscoUpdateDto() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
