package ifrs.dev2.buyer.repositorios;

import org.springframework.data.repository.CrudRepository;
import ifrs.dev2.buyer.dados.Movimento;

import java.util.List;

public interface MovimentoRepository extends CrudRepository<Movimento, Long>{

        List<Movimento> findByIdContaining(Long Id);

}