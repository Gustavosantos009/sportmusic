package com.example.spotmusic.controllers;

import com.example.spotmusic.model.Music;
import com.example.spotmusic.model.Playlist;
import com.example.spotmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("playlist/{playlistId}/music")
public class MusicController {
    @Autowired
    MusicService service;

   @GetMapping("/list")
    public ModelAndView listar(@PathVariable("playlistId") long playlistId,ModelMap model){

        model.addAttribute("musicas",service.listarPorPlaylist(playlistId));
        model.addAttribute("playlistid",playlistId);
        return new ModelAndView("Music/listMusic",model);
    }
    @GetMapping("cadastro")
    public String precadastro(@PathVariable("playlistId") long playlistId, @ModelAttribute ("music") Music music,ModelMap model){
        model.addAttribute("playlistid",playlistId);
       return "Music/addMusic";
    }
    @PostMapping("/salvar")
    public String salvaPlaylist(@PathVariable("playlistId") long playlistId,@ModelAttribute("music") Music music, BindingResult result, RedirectAttributes attr){

        if (result.hasErrors()) {
            return "Music/addMusic";
        }

        service.salvaMusic(playlistId,music);
        attr.addFlashAttribute("mensagem", "Musica salva com sucesso.");
        return "redirect:list";

    }
}
