package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Material;
import ifrs.dev2.buyer.dados.Receita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.util.List;

public interface ReceitaRepository extends CrudRepository<Receita, Long> {

    List<Receita> findByNomeContaining(String nome);

    @Query("select r from Receita r where r.produto.id = :produtoId")
    List<Receita> findByProdutoId(@Param("produtoId") Long produtoId);

    @Query("select r from Receita r where r.produto.id = :materialId")
    List<Receita> findByMaterialId(@Param("materialId") Long materialId);

    @Query("select r from Receita r where r.produto.id <> 0")
    List<Receita> findTudo();

}
