package br.com.oauth2.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String usuario;

    @NotEmpty
    private String senha;

    @NotEmpty
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Perfil> perfis;

    public Usuario() {
    }

    public Usuario(Usuario usuario) {
        this.usuario = usuario.getUsuario();
        this.senha = usuario.getSenha();
        this.nome = usuario.getNome();
        this.perfis = usuario.getPerfis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() { return senha; }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Perfil> getPerfis() { return perfis; }

    public void setPerfis(List<Perfil> perfis) { this.perfis = perfis; }

}