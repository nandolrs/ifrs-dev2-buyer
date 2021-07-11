package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Local;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface LocalRepository extends CrudRepository<ifrs.dev2.buyer.dados.Local, Long> {

    List<Local> findByNomeContaining(String nome);
    //List<Local> findAll(Sort nome);

}