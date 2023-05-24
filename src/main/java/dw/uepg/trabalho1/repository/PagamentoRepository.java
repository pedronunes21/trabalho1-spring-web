package dw.uepg.trabalho1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dw.uepg.trabalho1.model.Jogador;
import dw.uepg.trabalho1.model.Pagamento;
import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    // Pagamento createPagamento(int ano, int mes, float valor, long cod_jogador);

    // Pagamento getPagamento(long cod_pagamento);

    List<Pagamento> findByCodJogador(Jogador codJogador);

}
