package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Embalagem;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.EmbalagemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path="/api/embalagem")
public class EmbalagemController {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.EmbalagemRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public @ResponseBody
    EmbalagemResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody Embalagem entidade) throws Exception {

        try
        {
            repositorio.save(entidade);

            return new EmbalagemResponse( entidade,null,null);
        }

        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EmbalagemResponse retorno = new  EmbalagemResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EmbalagemResponse Pesquisar(@RequestHeader HttpHeaders headers,@RequestParam String nome)
    {
        try
        {
            List<Embalagem> retorno = null;

            if(nome.length() > 0)
            {
                retorno = repositorio.findByNomeContaining(nome);
            }
            else
            {
                retorno = repositorio.findByNomeContaining(nome);
            }

            retorno.sort(Comparator.comparing(Embalagem::getNome ));

            return new EmbalagemResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EmbalagemResponse retorno = new  EmbalagemResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EmbalagemResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Embalagem retorno = new Embalagem();
        try
        {
            retorno  = repositorio.findById(id).get();

            return new EmbalagemResponse( retorno,null,null);
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  EmbalagemResponse(null, erroBase, null) ;

        }

    }

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  Embalagem Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long   id) {

        Embalagem retorno = new Embalagem();
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
    EmbalagemResponse Listar(@RequestHeader HttpHeaders headers)
    {
        try
        {
            String nome="";
            List<Embalagem> retorno = retorno = repositorio.findByNomeContaining(nome);

            retorno.sort(Comparator.comparing(Embalagem::getNome ));

            return new EmbalagemResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EmbalagemResponse retorno = new  EmbalagemResponse(null, erroBase, null) ;
            return retorno;
        }
    }



}