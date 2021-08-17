package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Receita;
import ifrs.dev2.buyer.dados.Usuario;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.ReceitaResponse;
import ifrs.dev2.buyer.segurancas.Cripto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;

@RestController
@RequestMapping(path = "/api/receita")
public class ReceitaController {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.ReceitaRepository repositorio;

    @Autowired
    private ifrs.dev2.buyer.repositorios.UsuarioAutenticadorRepository repositorioUsuarioAutenticador;


    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public @ResponseBody
    ifrs.dev2.buyer.respostas.ReceitaResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody ifrs.dev2.buyer.dados.Receita entidade) throws Exception {

        try {
            entidade.setUsuario(Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador));
            entidade = repositorio.save(entidade);

            return new ReceitaResponse(entidade, null, null);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaResponse retorno = new ReceitaResponse(null, erroBase, null);
            return retorno;
        }
    }


    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaResponse Pesquisar(@RequestHeader HttpHeaders headers, @RequestParam String nome) // @RequestHeader HttpHeaders headers,
    {
        try {
            Usuario usuario = Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador); //
            List<Receita> retorno = null;

            if (nome.length() > 0) {
                retorno = repositorio.findByNomeContaining(nome, usuario.getId());
            } else {
                retorno = repositorio.findByNomeContaining(nome, usuario.getId());
            }

            retorno.sort(Comparator.comparing(Receita::getNome));

            return new ReceitaResponse(null, null, retorno);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaResponse retorno = new ReceitaResponse(null, erroBase, null);
            return retorno;
        }
    }

    @GetMapping(
            path = "consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Receita retorno = new Receita();
        try {
            retorno = repositorio.findById(id).get();

            return new ReceitaResponse(retorno, null, null);
        } catch (Exception e) {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return new ReceitaResponse(null, erroBase, null);

        }

    }

    @GetMapping(
            path = "excluir/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    Receita Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Receita retorno = new Receita();
        try {
            retorno = repositorio.findById(id).get();
            repositorio.deleteById(retorno.getId());
        } catch (Exception e) {
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
    ReceitaResponse Listar(@RequestHeader HttpHeaders headers) {
        try {
            Usuario usuario = Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador); //

            String nome = "";
            List<Receita> retorno = retorno = repositorio.findByNomeContaining(nome, usuario.getId());

            retorno.sort(Comparator.comparing(Receita::getNome));

            return new ReceitaResponse(null, null, retorno);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaResponse retorno = new ReceitaResponse(null, erroBase, null);
            return retorno;
        }
    }

    @GetMapping(
            value = "pesquisarPorProdutoXMaterial"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaResponse PesquisarPorProdutoMaterial(@RequestHeader HttpHeaders headers, @RequestParam Long produtoId, @RequestParam Long materialId) // @RequestHeader HttpHeaders headers,
    {
        try {

            Usuario usuario = Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador); //

            List<Receita> retorno = null;

            if (produtoId != 0) {
                retorno = repositorio.findByProdutoId(produtoId, usuario.getId());
            } else if (materialId != 0) {
                retorno = repositorio.findByMaterialId(materialId);
            } else {
                retorno = repositorio.findTudo(usuario.getId());
            }

            //  retorno.sort(Comparator.comparing(Receita::getNome));

            return new ReceitaResponse(null, null, retorno);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaResponse retorno = new ReceitaResponse(null, erroBase, null);
            return retorno;
        }
    }

    List<Receita> BuscaPorMaterial(Long materialId) {
        //Query  q = Session.createNamedQuery("ReceitaPorMaterial", ifrs.dev2.buyer.dados.Receita.class);
        //q.setParameter("materialId",materialId);
        //List<ifrs.dev2.buyer.dados.Receita> retorno = q.getResultList();;

        return repositorio.findByMaterialId(materialId);

    }

}
