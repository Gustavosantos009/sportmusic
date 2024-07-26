package com.example.spotmusic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.spotmusic.model.Playlist;
import com.example.spotmusic.repositories.PlaylistRepository;
@Service
public class PlaylistService {
    
     
    @Autowired
    PlaylistRepository repository;
    public void salvarPlaylist(Playlist playlist){
        repository.save(playlist);
    }

    public List<Playlist> listar(){

       return repository.findAll();

    }

    public Playlist listarPorId(long id){
        Playlist playlist = repository.getById(id);

        return playlist;
    }

    public void excluir(long id ){

        repository.delete(listarPorId(id));

    }

    public void atualiza(long id){

        Playlist playlist = repository.getById(id);

    }
}
