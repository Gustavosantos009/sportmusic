package com.example.spotmusic.repositories;

import com.example.spotmusic.model.Playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository  extends JpaRepository<Playlist, Long> {

}
