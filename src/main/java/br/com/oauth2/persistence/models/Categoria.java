package br.com.oauth2.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @JsonBackReference
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria that = (Categoria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
