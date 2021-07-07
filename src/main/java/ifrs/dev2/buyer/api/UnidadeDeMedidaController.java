package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Classe;
import ifrs.dev2.buyer.dados.DadoInterface;
import ifrs.dev2.buyer.dados.UnidadeDeMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(path="/api/local") 
public class UnidadeDeMedidaController  {
	
	long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.UnidadeDeMedidaRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    UnidadeDeMedida Salvar(@RequestBody ifrs.dev2.buyer.dados.UnidadeDeMedida entidade) {

        repositorio.save(entidade);

        return entidade;
    }
}