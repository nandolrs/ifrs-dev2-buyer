package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.*;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.EmbalagemResponse;
import ifrs.dev2.buyer.respostas.UnidadeMedidaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    UnidadeMedidaResponse Pesquisar(@RequestHeader HttpHeaders headers, @RequestParam String nome) {

        try
        {
            List<UnidadeMedida> retorno = repositorio.findByNomeContaining(nome);

//            return retorno;
            return new UnidadeMedidaResponse( null,null,retorno);

        }

        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            UnidadeMedidaResponse retorno = new UnidadeMedidaResponse(null, erroBase, null) ;
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
    UnidadeMedidaResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        UnidadeMedida retorno = new UnidadeMedida();
        try
        {
            retorno  = repositorio.findById(id).get();

            return new UnidadeMedidaResponse( retorno,null,null);
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  UnidadeMedidaResponse(null, erroBase, null) ;

        }

    }

}