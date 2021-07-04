package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findByNomeContaining(String nome);
}