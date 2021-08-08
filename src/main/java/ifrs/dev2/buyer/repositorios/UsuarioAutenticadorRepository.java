package ifrs.dev2.buyer.repositorios;
import ifrs.dev2.buyer.dados.UsuarioAutenticador;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioAutenticadorRepository extends CrudRepository<UsuarioAutenticador, Long> {



    Optional<UsuarioAutenticador> findBySessao (String sessao);}



