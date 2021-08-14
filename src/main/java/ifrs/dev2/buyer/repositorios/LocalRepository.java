package ifrs.dev2.buyer.repositorios;

import ifrs.dev2.buyer.dados.Local;
import ifrs.dev2.buyer.dados.Material;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface LocalRepository extends CrudRepository<ifrs.dev2.buyer.dados.Local, Long> {

    @Query("select l from Local l where l.nome like %:nome% and l.usuario.id = :usuarioId")
    List<Local> PesquisarLocal(@Param("nome") String nome, @Param("usuarioId") Long usuarioId);

    @Query(value = "select l.id, l.nome from Local l where l.id = :localId and l.usuario_id = :usuarioId"
            , nativeQuery = true)
    Local ConsultarLocal(@Param("localId") Long localId, @Param("usuarioId") Long usuarioId);

    @Query("select l from Local l where  l.usuario.id = :usuarioId")
    List<Local> PesquisarTudo(@Param("usuarioId") Long usuarioId);

}