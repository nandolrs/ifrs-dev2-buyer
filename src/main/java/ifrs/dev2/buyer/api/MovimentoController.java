package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
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
        Movimento Salvar(@RequestBody Movimento entidade) {

            repositorio.save(entidade);

            return entidade;
        }

        @GetMapping(
                value = "pesquisar"
                , produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        public @ResponseBody
        List<Movimento> Pesquisar(@RequestParam Long id) {

            List<Movimento> retorno = repositorio.findByIdContaining(id);

            return retorno;
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
        Movimento Consultar(@PathVariable Long id) {

            Movimento retorno = new Movimento();
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
}
