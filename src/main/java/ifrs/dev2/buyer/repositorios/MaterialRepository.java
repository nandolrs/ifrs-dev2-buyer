package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Material;
import ifrs.dev2.buyer.dados.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialRepository extends CrudRepository<Material, Long> {
    List<Material> findByProdutoContaining(Produto produto);

    @Query("select m from Material m where m.produto.id = :produtoId")
    List<Material> findByProdutoId(@Param("produtoId") Long produtoId);


    @Query("select m from Material m")
    List<Material> findByTudo();


}