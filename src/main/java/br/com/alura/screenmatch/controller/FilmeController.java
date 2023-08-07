package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosAlteracaoFilme;
import br.com.alura.screenmatch.domain.filme.DadosCadastraFilme;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public String carregaPaginaListagem(Model model) {
       model.addAttribute("lista", filmeRepository.findAll());
        return "filmes/listagem";
    }

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var filme = filmeRepository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

    @PostMapping
    @Transactional
    public String cadastraFilme(DadosCadastraFilme dadosCadastraFilme) {
        Filme filme = new Filme(dadosCadastraFilme);
        filmeRepository.save(filme);

        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id) {
        filmeRepository.deleteById(id);

        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String alteraFilme(DadosAlteracaoFilme dadosAlteracaoFilme) {
        var filme = filmeRepository.getReferenceById(dadosAlteracaoFilme.id());
        filme.atualizaDados(dadosAlteracaoFilme);

        return "redirect:/filmes";
    }
}
