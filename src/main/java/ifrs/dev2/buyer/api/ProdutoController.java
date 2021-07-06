package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List; // fernando

@RestController
@RequestMapping(path="/api/produto")
public class ProdutoController  {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.ProdutoRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Produto Salvar(@RequestBody Produto entidade) {

        repositorio.save(entidade);

        return entidade;
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    List<Produto> Pesquisar(@RequestParam String nome) {

        List<Produto> retorno = repositorio.findByNomeContaining(nome);
        return retorno;
    }

    @GetMapping(
             path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Produto Consultar(@PathVariable Long id) {

        Produto retorno = new Produto();
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
    public @ResponseBody  Produto Excluir(@PathVariable Long   id) {

        Produto retorno = new Produto();
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

