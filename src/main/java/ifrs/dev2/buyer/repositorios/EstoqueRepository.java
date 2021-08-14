package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Estoque;
import ifrs.dev2.buyer.dados.Receita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

    @Query(value = "\n" +
            "select e\n" +
            "from Estoque e\n" +
            "where e.local.id  = :localId\n" +
            "and e.material.id = :materialId\n"
            , nativeQuery = false)
    List <Estoque> PesquisarPorLocalEMaterial(@Param("localId") Long localId, @Param("materialId") Long materialId );

    @Query(value = "\n" +
            "select e\n" +
            "from Estoque e\n" +
            "where e.local.id  = :localId\n" +
            "and e.local.usuario.id  = :usuarioId\n"
            , nativeQuery = false)
    List <Estoque> PesquisarPorLocal(@Param("localId") Long localId,@Param("usuarioId") Long usuarioId);


    @Query(value = "\n" +
            "select e\n" +
            "from Estoque e\n" +
            "where e.material.id = :materialId\n"+
            "and e.local.usuario.id  = :usuarioId\n"
            , nativeQuery = false)
    List <Estoque> PesquisarPorMaterial(@Param("materialId") Long materialId, @Param("usuarioId") Long usuarioId );


    @Query(value = "\n" +
            "select e\n" +
            "from Estoque e\n" +
            "where e.local.usuario.id  = :usuarioId\n"
            , nativeQuery = false)
    List <Estoque> findByTudo(@Param("usuarioId") Long usuarioId );

}