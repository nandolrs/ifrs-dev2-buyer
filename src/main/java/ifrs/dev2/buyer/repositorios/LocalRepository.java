package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Local;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocalRepository extends CrudRepository<ifrs.dev2.buyer.dados.Local, Long> {

    List<Local> findByNomeContaining(String nome);
}