package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Estabelecimento;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.EstabelecimentoResponse;
import ifrs.dev2.buyer.segurancas.Cripto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path="/api/estabelecimento")
public class EstabelecimentoController {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.EstabelecimentoRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public @ResponseBody
    EstabelecimentoResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody Estabelecimento entidade) throws Exception {

        try
        {
            entidade = repositorio.save(entidade);

            return new EstabelecimentoResponse( entidade,null,null);
        }

        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EstabelecimentoResponse retorno = new  EstabelecimentoResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EstabelecimentoResponse Pesquisar(@RequestHeader HttpHeaders headers,@RequestParam String nomeFantasia)
    {
        try
        {

            List<Estabelecimento> retorno = null;

            if(nomeFantasia.length() > 0)
            {
                retorno = repositorio.findByNomeFantasiaContaining(nomeFantasia);
            }
            else
            {
                retorno = repositorio.findByTudo();
            }

            retorno.sort(Comparator.comparing(Estabelecimento::getNomeFantasia ));

            return new EstabelecimentoResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EstabelecimentoResponse retorno = new  EstabelecimentoResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EstabelecimentoResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Estabelecimento retorno = new Estabelecimento();
        try
        {
            retorno  = repositorio.findById(id).get();

            return new EstabelecimentoResponse( retorno,null,null);
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  EstabelecimentoResponse(null, erroBase, null) ;

        }

    }

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  Estabelecimento Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long   id) {

        Estabelecimento retorno = new Estabelecimento();
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

    void ErroLancar() throws Exception {
        throw new Exception("deu merda");
    }

    @GetMapping(
            value = "listar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EstabelecimentoResponse Listar(@RequestHeader HttpHeaders headers)
    {
        try
        {
            List<Estabelecimento> retorno = retorno = repositorio.findByTudo();

            retorno.sort(Comparator.comparing(Estabelecimento::getNomeFantasia ));

            return new EstabelecimentoResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EstabelecimentoResponse retorno = new  EstabelecimentoResponse(null, erroBase, null) ;
            return retorno;
        }
    }



}