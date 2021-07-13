package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.DadoInterface;
import ifrs.dev2.buyer.dados.Local;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.LocalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/api/local") // This means URL's start with /demo (after Application path)
public class LocalController  {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ifrs.dev2.buyer.repositorios.LocalRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    ) // Map ONLY POST Requests

    public @ResponseBody
    ifrs.dev2.buyer.respostas.LocalResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody ifrs.dev2.buyer.dados.Local entidade) throws Exception {

        try
        {
            repositorio.save(entidade);

            return new LocalResponse( entidade,null,null);
        }

        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            LocalResponse retorno = new  LocalResponse(null, erroBase, null) ;
            return retorno;
        }
    }


    //@CrossOrigin() // origins = "http://localhost:3000"
    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    LocalResponse Pesquisar(@RequestHeader HttpHeaders headers,@RequestParam String nome) // @RequestHeader HttpHeaders headers,
    {
        try
        {
            List<Local> retorno = null;

            if(nome.length() > 0)
            {
                retorno = repositorio.findByNomeContaining(nome);
            }
            else
            {
                //Sort sort = new Sort(direction, ordering);
                //PageRequest page = new PageRequest(xoffset, xbase, sort);

                //retorno = repositorio.findAll(Sort.by(Sort.Direction.ASC, "nome"));

                retorno = repositorio.findByNomeContaining(nome);
            }

            return new LocalResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            LocalResponse retorno = new  LocalResponse(null, erroBase, null) ;

            return retorno;
        }
    }

    @GetMapping(
             path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    LocalResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Local retorno = new Local();
        try
        {
            retorno  = repositorio.findById(id).get();

            return new LocalResponse( retorno,null,null);
        }

        catch (Exception e)
        {
             retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  LocalResponse(null, erroBase, null) ;

        }

    }

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  Local Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long   id) {

        Local retorno = new Local();
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

}

