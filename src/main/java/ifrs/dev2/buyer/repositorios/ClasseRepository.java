package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Classe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClasseRepository extends CrudRepository<Classe, Long> {
    List<Classe> findByNomeContaining(String nome);
}