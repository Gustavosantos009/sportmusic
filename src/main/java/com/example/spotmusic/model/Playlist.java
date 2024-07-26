package com.example.spotmusic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 60)
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Music> musicas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Music> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Music> musicas) {
        this.musicas = musicas;
    }

}
