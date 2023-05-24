package dw.uepg.trabalho1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dw.uepg.trabalho1.model.Jogador;
import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findByCodJogador(long codJogador);

}
