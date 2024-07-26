package com.example.spotmusic.controllers;

import com.example.spotmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spotmusic.model.Playlist;

@Controller
@RequestMapping("playlists")
public class PlaylistsController {
    
    @Autowired
    PlaylistService service;

    @GetMapping("")
    public ModelAndView listar(ModelMap model){

        model.addAttribute("playlists",service.listar());

        return new ModelAndView("home",model);
    }
    @GetMapping("cadastro")
    public String preSalvar(@ModelAttribute("playlist") Playlist playlist) {
        return "Playlist/addPlaylist";
    }


    @PostMapping("/salvar")
    public String salvaPlaylist(@ModelAttribute("playlist")Playlist playlist, BindingResult result, RedirectAttributes attr){

        if (result.hasErrors()) {
            return "Playlist/addPlaylist";
        }

        service.salvarPlaylist(playlist);
        attr.addFlashAttribute("mensagem", "Playlist criada com sucesso.");
        return "redirect:/playlists";

    }

    @GetMapping("/excluir/{id}")
    public String delete (@PathVariable("id") long id,RedirectAttributes attr){

        service.excluir(id);

        attr.addFlashAttribute("mensagem", "Playlist excluida com sucesso.");
        return "redirect:/playlists";

    }

    @GetMapping("/aditar/{id}")
    public ModelAndView preEdicao(@PathVariable("id")long id,ModelMap model ){

        Playlist playlist =service.listarPorId(id);

        model.addAttribute("playlist",playlist);

        return new ModelAndView("PLaylist/addPlaylist",model);

    }
    @PostMapping("/atualizar")
    public String atualiza ( @ModelAttribute("playlist") Playlist playlist,BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "Playlist/addPlaylist";
        }
        service.atualiza(playlist);
        attr.addFlashAttribute("mensagem", "Playlist atualizada com sucesso.");
        return "redirect:/playlists";
    }
}
