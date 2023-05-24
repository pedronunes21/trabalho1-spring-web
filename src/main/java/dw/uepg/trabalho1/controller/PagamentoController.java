package dw.uepg.trabalho1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dw.uepg.trabalho1.model.Jogador;
import dw.uepg.trabalho1.model.Pagamento;
import dw.uepg.trabalho1.repository.JogadorRepository;
import dw.uepg.trabalho1.repository.PagamentoRepository;
import dw.uepg.trabalho1.types.PagamentoRequest;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoRepository rep;

    @Autowired
    JogadorRepository jogadorRep;

    @PostMapping("/")
    public ResponseEntity<Pagamento> createPagamento(@RequestBody PagamentoRequest p) {
        try {

            List<Jogador> _j = jogadorRep.findByCodJogador(p.getCodJogador());

            if (_j == null)
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            Jogador j = _j.get(0);

            Pagamento _pagamento = rep.save(new Pagamento(p.getAno(), p.getMes(), p.getValor(), j));

            return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Pagamento>> listPagamento() {
        try {
            List<Pagamento> pagamentos = new ArrayList<Pagamento>();

            rep.findAll().forEach(pagamentos::add);

            if (pagamentos.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(pagamentos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{codJogador}")
    @ResponseBody
    public ResponseEntity<List<Pagamento>> getPagamentoByEmail(@PathVariable("codJogador") long codJogador) {
        try {
            System.out.println(codJogador);
            List<Jogador> _j = jogadorRep.findByCodJogador(codJogador);
            System.out.println(_j);

            if (_j.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            Jogador j = _j.get(0);

            List<Pagamento> pagamentos = new ArrayList<Pagamento>();

            rep.findByCodJogador(j).forEach(pagamentos::add);

            if (pagamentos.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(pagamentos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
