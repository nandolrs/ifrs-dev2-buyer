package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Classe;
import ifrs.dev2.buyer.dados.DadoInterface;
import ifrs.dev2.buyer.dados.Produto;
import ifrs.dev2.buyer.dados.UnidadeMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(path="/api/UnidadeMedida")
public class UnidadeMedidaController  {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.UnidadeMedidaRepository repositorio;
//insert
    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    UnidadeMedida Salvar(@RequestBody UnidadeMedida entidade) {

        repositorio.save(entidade);

        return entidade;
    }
//responsive
    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    List<UnidadeMedida> Pesquisar(@RequestParam String nome) {

        List<UnidadeMedida> retorno = repositorio.findByNomeContaining(nome);

        return retorno;
    }

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  UnidadeMedida Excluir(@PathVariable Long   id) {

        UnidadeMedida retorno = new UnidadeMedida();
        try
        {
            retorno  = repositorio.findById(id).get();
            repositorio.deleteById(retorno.getId());
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);
        }

        return retorno;
    }
    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    UnidadeMedida Consultar(@PathVariable Long id) {

        UnidadeMedida retorno = new UnidadeMedida();
        try
        {
            retorno  = repositorio.findById(id).get();
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);
        }

        return retorno;
}
}