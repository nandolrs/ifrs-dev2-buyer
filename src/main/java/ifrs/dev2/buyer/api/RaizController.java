package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.DadoInterface;
import ifrs.dev2.buyer.dados.Local;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.respostas.LocalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class RaizController  {

    @GetMapping(
            value = "/"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    String Raiz(@RequestHeader HttpHeaders headers) // @RequestHeader HttpHeaders headers,
    {
        return "IFRS - Restinga - ADS - Dev2 - Grupo 3 (2021) - Buyer - Fernando Rodrigues, Leonardo Oliveira, Rafael Pinto, Tiago Ribeiro ";
    }


}

