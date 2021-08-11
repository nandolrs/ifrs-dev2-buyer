package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.*;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.EmbalagemResponse;
import ifrs.dev2.buyer.respostas.MovimentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Comparator;
import java.util.Date;
import java.util.List;



    @RestController
    @RequestMapping(path="/api/movimento")
    public class MovimentoController {

        long ID_NAO_ENCONTRADO = -1;

        @Autowired
        private ifrs.dev2.buyer.repositorios.MovimentoRepository repositorio;
        //insert
        @PostMapping(
                value = "salvar"
                , consumes = {MediaType.APPLICATION_JSON_VALUE}
                , produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        public @ResponseBody
        MovimentoResponse Salvar(@RequestHeader HttpHeaders headers, @RequestBody Movimento entidade) throws Exception {

            try
            {
                repositorio.save(entidade);

                return new MovimentoResponse( entidade,null,null);
            }

            catch(Exception e)
            {
                String msg = "deu merda";

                ErroItem item = new ErroItem("",msg,-1L);
                //ErroBase erroBase = new ErroBase(e);
                ErroBase erroBase = new ErroBase(item);

                MovimentoResponse retorno = new  MovimentoResponse(null, erroBase, null) ;
                return retorno;
            }
        }

        @GetMapping(
                value = "pesquisar"
                , produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        MovimentoResponse Pesquisar(@RequestHeader HttpHeaders headers, @RequestParam Date dataMovimento, @RequestParam float quantidade, @RequestParam Long estabelecimentoId, @RequestParam Long materialId)
        {
            try {
                List<Movimento> retorno = null;

                if (dataMovimento == new Date(0)) {
                    retorno = repositorio.findBydataMovimentoContaining(dataMovimento);
                } else if (quantidade > 0) {
                    retorno = repositorio.findByQuantidadeContaining(quantidade);
                } else if (estabelecimentoId > 0) {
                    retorno = repositorio.findByEstabelecimentoId(estabelecimentoId);
                } else if (materialId > 0) {
                    retorno = repositorio.findByMaterialId(materialId);
                } else {
                    retorno = repositorio.findByTudo();
                }

                retorno.sort(Comparator.comparing(Movimento::getNome ));

                return new MovimentoResponse( null,null,retorno);
            }
            catch(Exception e)
            {
                String msg = "deu merda";

                ErroItem item = new ErroItem("",msg,-1L);
                //ErroBase erroBase = new ErroBase(e);
                ErroBase erroBase = new ErroBase(item);

                MovimentoResponse retorno = new  MovimentoResponse(null, erroBase, null) ;
                return retorno;
            }
        }
        @GetMapping(
                path="excluir/{id}"
                ,produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        public @ResponseBody  Movimento Excluir(@PathVariable Long   id) {

            Movimento retorno = new Movimento();
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
        @GetMapping(
                path="consultar/{id}"
                , produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        public @ResponseBody
        MovimentoResponse Consultar(@RequestHeader HttpHeaders headers, @PathVariable Long id) {

            Movimento retorno = new Movimento();
            try {
                retorno = repositorio.findById(id).get();

                return new MovimentoResponse(retorno, null, null);
            } catch (Exception e) {
                retorno.setId(ID_NAO_ENCONTRADO);

                String msg = "deu merda";

                ErroItem item = new ErroItem("", msg, -1L);
                //ErroBase erroBase = new ErroBase(e);
                ErroBase erroBase = new ErroBase(item);

                return new MovimentoResponse(null, erroBase, null);

            }
        }
        @GetMapping(
                value = "listar"
                , produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        public @ResponseBody
        MovimentoResponse Listar(@RequestHeader HttpHeaders headers, @RequestParam Date dataMovimento)
        {
            try
            {
                String nome="";
                List<Movimento> retorno = retorno = repositorio.findBydataMovimentoContaining(dataMovimento);

                retorno.sort(Comparator.comparing(Movimento::getNome ));

                return new MovimentoResponse( null,null,retorno);
            }
            catch(Exception e)
            {
                String msg = "deu merda";

                ErroItem item = new ErroItem("",msg,-1L);
                //ErroBase erroBase = new ErroBase(e);
                ErroBase erroBase = new ErroBase(item);

                MovimentoResponse retorno = new  MovimentoResponse(null, erroBase, null) ;
                return retorno;
            }
        }




    }

