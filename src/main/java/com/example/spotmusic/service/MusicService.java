package com.example.spotmusic.service;

import com.example.spotmusic.model.Music;
import com.example.spotmusic.repositories.MusicRepository;
import com.example.spotmusic.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepository repository;

    @Autowired
    PlaylistRepository  playlistRepository;

    public List<Music> listarPorPlaylist(long idPlaylist){

      return repository.buscarPorPlaylist(idPlaylist);

    }
    public void salvaMusic(long idPlaylist, Music music ){

        music.setPlaylist(playlistRepository.getById(idPlaylist));

        repository.save(music);
    }
    public void atualizar( long idPlaylist,Music music ){
        music.setPlaylist(playlistRepository.getById(idPlaylist));
        repository.save(music);
    }

    public void excluirMusic ( long idMusic){

        repository.delete(listPorId(idMusic));
    }

    public Music listPorId(long idMusic){

        return repository.getById(idMusic);
    }

}
