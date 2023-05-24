package dw.uepg.trabalho1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dw.uepg.trabalho1.model.Jogador;
import dw.uepg.trabalho1.repository.JogadorRepository;

@RestController
@RequestMapping("/api/jogador")
public class JogadorController {

    @Autowired
    JogadorRepository rep;

    @PostMapping("/")
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador j) {
        try {
            Jogador _jogador = rep.save(new Jogador(j.getNome(), j.getEmail(),
                    j.getDatanasc()));

            return new ResponseEntity<>(_jogador, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Jogador>> listJogadores() {
        try {
            List<Jogador> jogadores = new ArrayList<Jogador>();

            rep.findAll().forEach(jogadores::add);

            if (jogadores.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(jogadores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
