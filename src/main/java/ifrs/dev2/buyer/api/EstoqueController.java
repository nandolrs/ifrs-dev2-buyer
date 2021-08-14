package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Estoque;
import ifrs.dev2.buyer.dados.Produto;
import ifrs.dev2.buyer.dados.Usuario;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.EstoqueResponse;
import ifrs.dev2.buyer.segurancas.Cripto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path="/api/estoque")
public class EstoqueController {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.EstoqueRepository repositorio;

    @Autowired
    private ifrs.dev2.buyer.repositorios.UsuarioAutenticadorRepository repositorioUsuarioAutenticador;

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EstoqueResponse Pesquisar(@RequestHeader HttpHeaders headers,@RequestParam Long localId,@RequestParam Long materialId)
    {
        try
        {
            Usuario usuario = Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador); //

            List<Estoque> retorno = null;

            if(localId > 0)
            {
                retorno = repositorio.PesquisarPorLocal(localId,usuario.getId());
            } if (materialId > 0)
            {
                retorno = repositorio.PesquisarPorMaterial(materialId,usuario.getId());

            }
            else
            {
                retorno = repositorio.findByTudo(usuario.getId());
            }

            retorno.sort(Comparator.comparing(Estoque::getQuantidade ));

            return new EstoqueResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EstoqueResponse retorno = new  EstoqueResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EstoqueResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Estoque retorno = new Estoque();
        try
        {

            retorno  = repositorio.findById(id).get();

            return new EstoqueResponse( retorno,null,null);
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  EstoqueResponse(null, erroBase, null) ;

        }

    }


    @GetMapping(
            value = "listar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    EstoqueResponse Listar(@RequestHeader HttpHeaders headers)
    {
        try
        {
            Usuario usuario = Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador); //

            List<Estoque> retorno = null;

            Produto produto = new Produto();

            retorno = repositorio.findByTudo(usuario.getId());

            return new EstoqueResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EstoqueResponse retorno = new  EstoqueResponse(null, erroBase, null) ;
            return retorno;
        }
    }


}