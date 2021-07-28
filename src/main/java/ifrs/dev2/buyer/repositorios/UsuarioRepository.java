package ifrs.dev2.buyer.repositorios;
import org.springframework.data.repository.CrudRepository;
import ifrs.dev2.buyer.dados.Usuario;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	List<Usuario> findByNomeContaining(String nome);

}