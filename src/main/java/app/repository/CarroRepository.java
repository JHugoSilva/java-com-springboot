package app.repository;

import app.entity.Carro;
import app.entity.Marca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query("SELECT c FROM Carro c JOIN FETCH c.proprietarios")
    List<Carro> findAllWithProprietarios();

    @Query("SELECT c FROM Carro c JOIN FETCH c.proprietarios JOIN FETCH c.proprietarios WHERE c.nome = :nome")
    public List<Carro> findByNome(@Param("nome") String nome);

    public List<Carro> findByMarca(Marca marca);

    @Query("SELECT c FROM Carro c JOIN FETCH c.proprietarios WHERE c.ano > :ano")
    public List<Carro> findAcimaAno(int ano);
}
