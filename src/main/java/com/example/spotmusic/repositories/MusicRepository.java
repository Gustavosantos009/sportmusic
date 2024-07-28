package com.example.spotmusic.repositories;

import com.example.spotmusic.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {

    @Query(value = "SELECT * FROM  musicas where musicas.id_playlist_fk = :id" , nativeQuery = true)
    public List<Music> buscarPorPlaylist( @Param("id") Long id);

}
