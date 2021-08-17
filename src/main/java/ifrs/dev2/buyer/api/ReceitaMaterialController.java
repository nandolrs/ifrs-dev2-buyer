package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.ReceitaMaterial;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.ReceitaMaterialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/receitamaterial") // This means URL's start with /demo (after Application path)
public class ReceitaMaterialController {

    long ID_NAO_ENCONTRADO = -1;

    @Autowired
    private ifrs.dev2.buyer.repositorios.ReceitaMaterialRepository repositorio;

    @PostMapping(
            value = "salvar"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaMaterialResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody ReceitaMaterial entidade) throws Exception {

        try {
            repositorio.save(entidade);

            return new ReceitaMaterialResponse(entidade, null, null);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaMaterialResponse retorno = new ReceitaMaterialResponse(null, erroBase, null);
            return retorno;
        }
    }


    //@CrossOrigin() // origins = "http://localhost:3000"
    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaMaterialResponse Pesquisar(@RequestHeader HttpHeaders headers, @RequestParam Long receitaId)
    {
        try {
            List<ReceitaMaterial> retorno = null;

            retorno = repositorio.findByReceitaId(receitaId);

            return new ReceitaMaterialResponse(null, null, retorno);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaMaterialResponse retorno = new ReceitaMaterialResponse(null, erroBase, null);
            return retorno;
        }
    }

    @GetMapping(
            path = "consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaMaterialResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        ReceitaMaterial retorno = new ReceitaMaterial();
        try {
            retorno = repositorio.findById(id).get();

            return new ReceitaMaterialResponse(retorno, null, null);
        } catch (Exception e) {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return new ReceitaMaterialResponse(null, erroBase, null);

        }

    }

    @GetMapping(
            path = "excluir/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaMaterial Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        ReceitaMaterial retorno = new ReceitaMaterial();
        try {
            retorno = repositorio.findById(id).get();
            repositorio.deleteById(retorno.getId());
        } catch (Exception e) {
            retorno.setId(ID_NAO_ENCONTRADO);
        }

        return retorno;
    }

    @GetMapping(
            value = "listar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ReceitaMaterialResponse Listar(@RequestHeader HttpHeaders headers) {
        try {
            Long receitaId = Long.valueOf(0);
            List<ReceitaMaterial> retorno = retorno = repositorio.findByReceitaId(receitaId);

            return new ReceitaMaterialResponse(null, null, retorno);
        } catch (Exception e) {
            String msg = "deu merda";

            ErroItem item = new ErroItem("", msg, -1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ReceitaMaterialResponse retorno = new ReceitaMaterialResponse(null, erroBase, null);
            return retorno;
        }
    }

    void ErroLancar() throws Exception {
        throw new Exception("deu merda");
    }


}