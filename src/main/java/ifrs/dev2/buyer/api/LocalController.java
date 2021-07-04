package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.DadoInterface;
import ifrs.dev2.buyer.dados.Local;
import org.springframework.beans.factory.annotation.Autowired;
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
    ifrs.dev2.buyer.dados.Local Salvar(@RequestBody ifrs.dev2.buyer.dados.Local entidade) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        repositorio.save(entidade);

        return entidade;
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    List<Local> Pesquisar(@RequestParam String nome) {

        List<Local> retorno = repositorio.findByNomeContaining(nome);
        return retorno;
    }

    @GetMapping(
             path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Local Consultar(@PathVariable Long id) {

        Local retorno = new Local();
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

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  Local Excluir(@PathVariable Long   id) {

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
}

