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

    @Query("select r from Receita r where r.produto.id <> 0 and r.usuario.id = :usuarioId")
    List<Receita> findTudo(@Param("usuarioId") Long usuarioId);

    @Query("select r from Receita r where r.nome like %:nome% and r.usuario.id = :usuarioId")
    List<Receita> findByNomeContaining(@Param("nome") String nome, @Param("usuarioId") Long usuarioId);

    @Query("select r from Receita r where r.produto.id = :produtoId and r.usuario.id = :usuarioId")
    List<Receita> findByProdutoId(@Param("produtoId") Long produtoId, @Param("usuarioId") Long usuarioId);

    //@Query("select r from Receita r where r.material.id = :materialId and r.usuario.id = :usuarioId")
    //List<Receita> findByMaterialId(@Param("materialId") Long materialId, @Param("usuarioId") Long usuarioId);


    @Query(value = "select \n" +
            "r.*\n" +
            "from dbbuyer.receita r\n" +
            "where r.id <> 0 \n" +
            "and r.usuario.id = :usuarioId \n" +
            "and exists\n" +
            "(\n" +
            "\tselect 1 \n" +
            "    from dbbuyer.receita_material rm\n" +
            "    where rm.receita_id=r.id\n" +
            "\tand rm.material_id = :materialId \n" +
            ");\n"
            , nativeQuery = true)
    List<Receita> findByMaterialId(@Param("materialId") Long materialId);

}
