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

    @Query("select r from Receita r where r.produto.id <> 0")
    List<Receita> findTudo();

    List<Receita> findByNomeContaining(String nome);

    @Query("select r from Receita r where r.produto.id = :produtoId")
    List<Receita> findByProdutoId(@Param("produtoId") Long produtoId);

    @Query("select r from Receita r where r.produto.id = :materialId")
    List<Receita> findByMaterialId1(@Param("materialId") Long materialId);


    @Query(value = "select \n" +
            "r.*\n" +
            "from dbbuyer.receita r\n" +
            "where r.id <> 0 -- 998\n" +
            "and exists\n" +
            "(\n" +
            "\tselect 1 \n" +
            "    from dbbuyer.receita_material rm\n" +
            "    where rm.receita_id=r.id\n" +
            "\tand rm.material_id = 49 -- laranja\n" +
            ");\n"
            , nativeQuery = true)
    List<Receita> findByMaterialId(@Param("materialId") Long materialId);

}
