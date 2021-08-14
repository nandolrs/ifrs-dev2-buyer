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
            "select e.*\n" +
            "from estoque e\n" +
            "where e.local_id  = :localId\n" +
            "and e.material_id = :materialId;\n"
            , nativeQuery = true)
    List <Estoque> findByXXX1(@Param("localId") Long localId, @Param("materialId") Long materialId );


    @Query(value = "\n" +
            "select e\n" +
            "from Estoque e\n" +
            "where e.local.id  = :localId\n" +
            "and e.material.id = :materialId\n"
            , nativeQuery = false)
    List <Estoque> findByXXX(@Param("localId") Long localId, @Param("materialId") Long materialId );

}