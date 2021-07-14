package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Material;
import ifrs.dev2.buyer.dados.Produto;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.MaterialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path="/api/material")
public class MaterialController {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.MaterialRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    ) // Map ONLY POST Requests

    public @ResponseBody
    MaterialResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody Material entidade) throws Exception {

        try
        {
            repositorio.save(entidade);

            return new MaterialResponse( entidade,null,null);
        }

        catch (Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            MaterialResponse retorno = new  MaterialResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    MaterialResponse Pesquisar(@RequestHeader HttpHeaders headers,@RequestParam Long produtoId) // @RequestHeader HttpHeaders headers,
    {
        try
        {
            List<Material> retorno = null;

            Produto produto = new Produto(); produto.setId(produtoId);

            if(produto.getId() > 0)
            {
                retorno = repositorio.findByProdutoId(produto.getId());
            }
            else
            {
                retorno = repositorio.findByTudo();
            }

            retorno.sort(Comparator.comparing(Material::getNome ));

            return new MaterialResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            MaterialResponse retorno = new  MaterialResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    MaterialResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Material retorno = new Material();
        try
        {
            retorno  = repositorio.findById(id).get();

            return new MaterialResponse( retorno,null,null);
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  MaterialResponse(null, erroBase, null) ;

        }

    }

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  Material Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long   id) {

        Material retorno = new Material();
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
    MaterialResponse Listar(@RequestHeader HttpHeaders headers)
    {
        try
        {
            List<Material> retorno = null;

            Produto produto = new Produto();

            retorno = repositorio.findByProdutoContaining(produto);

            retorno.sort(Comparator.comparing(Material::getNome ));

            return new MaterialResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            MaterialResponse retorno = new  MaterialResponse(null, erroBase, null) ;
            return retorno;
        }
    }


}