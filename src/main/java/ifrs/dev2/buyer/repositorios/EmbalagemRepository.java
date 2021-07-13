package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Embalagem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmbalagemRepository extends CrudRepository<Embalagem, Long> {

    List<Embalagem> findByNomeContaining(String nome);
}