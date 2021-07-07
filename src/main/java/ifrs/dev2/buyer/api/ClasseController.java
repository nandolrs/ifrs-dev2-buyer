package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 //ok2sdfhjkldsok
@RestController
@RequestMapping(path="/api/classe")
public class ClasseController  {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.ClasseRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Classe Salvar(@RequestBody Classe entidade) {

        repositorio.save(entidade);

        return entidade;
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    List<Classe> Pesquisar(@RequestParam String nome) {

        List<Classe> retorno = repositorio.findByNomeContaining(nome);
        return retorno;
    }

    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Classe Consultar(@PathVariable Long id) {

        Classe retorno = new Classe();
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
    public @ResponseBody  Classe Excluir(@PathVariable Long   id) {

        Classe retorno = new Classe();
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

