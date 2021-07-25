package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.*;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.UnidadeMedidaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path="/api/unidademedida")
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
UnidadeMedidaResponse Pesquisar(@RequestHeader HttpHeaders headers, @RequestParam String nome)
{
    try
    {
        List<UnidadeMedida> retorno = null;

        if(nome.length() > 0)
        {
            retorno = repositorio.findByNomeContaining(nome);
        }
        else
        {
            retorno = repositorio.findByNomeContaining(nome);
        }

        retorno.sort(Comparator.comparing(UnidadeMedida::getNome ));

        return new UnidadeMedidaResponse( null,null,retorno);
    }
    catch(Exception e)
    {
        String msg = "vish";

        ErroItem item = new ErroItem("",msg,-1L);
        //ErroBase erroBase = new ErroBase(e);
        ErroBase erroBase = new ErroBase(item);

        UnidadeMedidaResponse retorno = new  UnidadeMedidaResponse(null, erroBase, null) ;
        return retorno;
    }
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