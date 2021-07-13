package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.DadoInterface;
import ifrs.dev2.buyer.dados.Classe;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.ClasseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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
    ifrs.dev2.buyer.respostas.ClasseResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody ifrs.dev2.buyer.dados.Classe entidade) throws Exception {

        try
        {
            repositorio.save(entidade);

            return new ClasseResponse( entidade,null,null);
        }

        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ClasseResponse retorno = new  ClasseResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            value = "pesquisar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ClasseResponse Pesquisar(@RequestHeader HttpHeaders headers,@RequestParam String nome)
    {
        try
        {
            List<Classe> retorno = null;

            if(nome.length() > 0)
            {
                retorno = repositorio.findByNomeContaining(nome);
            }
            else
            {
                retorno = repositorio.findByNomeContaining(nome);
            }

            retorno.sort(Comparator.comparing(Classe::getNome ));

            return new ClasseResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ClasseResponse retorno = new  ClasseResponse(null, erroBase, null) ;
            return retorno;
        }
    }

    @GetMapping(
            path="consultar/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ClasseResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

        Classe retorno = new Classe();
        try
        {
            retorno  = repositorio.findById(id).get();

            return new ClasseResponse( retorno,null,null);
        }

        catch (Exception e)
        {
            retorno.setId(ID_NAO_ENCONTRADO);

            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            return  new  ClasseResponse(null, erroBase, null) ;

        }

    }

    @GetMapping(
            path="excluir/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody  Classe Excluir(@RequestHeader HttpHeaders headers, @PathVariable Long   id) {

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

    void ErroLancar() throws Exception {
        throw new Exception("deu merda");
    }

    @GetMapping(
            value = "listar"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    ClasseResponse Listar(@RequestHeader HttpHeaders headers)
    {
        try
        {
            String nome="";
            List<Classe> retorno = retorno = repositorio.findByNomeContaining(nome);

            retorno.sort(Comparator.comparing(Classe::getNome ));

            return new ClasseResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            ClasseResponse retorno = new  ClasseResponse(null, erroBase, null) ;
            return retorno;
        }
    }



}