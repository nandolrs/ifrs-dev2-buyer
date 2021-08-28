package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.Classe;
import ifrs.dev2.buyer.dados.Estoque;
import ifrs.dev2.buyer.dados.Local;
import ifrs.dev2.buyer.dados.Usuario;
import ifrs.dev2.buyer.erros.ErroBase;
import ifrs.dev2.buyer.erros.ErroItem;
import ifrs.dev2.buyer.info.EstoquePorClasse;
import ifrs.dev2.buyer.respostas.ClasseResponse;
import ifrs.dev2.buyer.respostas.EstoquePorClasseResponse;
import ifrs.dev2.buyer.respostas.LocalResponse;
import ifrs.dev2.buyer.segurancas.Cripto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path="/api/info")
public class InfoController {

    @Autowired
    private ifrs.dev2.buyer.repositorios.UsuarioAutenticadorRepository repositorioUsuarioAutenticador;

    @Autowired
    private ApplicationContext ac;

    @GetMapping(
            value = "pesquisarEstoquePorClasse"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public @ResponseBody
    EstoquePorClasseResponse PesquisarEstoquePorClasse(@RequestHeader HttpHeaders headers, @RequestParam String nome) // @RequestHeader HttpHeaders headers,
    {
        try
        {
            //Usuario usuario = Cripto.Token2Usuario(headers,repositorioUsuarioAutenticador); //

            List<EstoquePorClasse> retorno = Painel();

//            retorno.sort(Comparator.comparing(Local::getNome ));

            return new EstoquePorClasseResponse( null,null,retorno);
        }
        catch(Exception e)
        {
            String msg = "deu merda";

            ErroItem item = new ErroItem("",msg,-1L);
            //ErroBase erroBase = new ErroBase(e);
            ErroBase erroBase = new ErroBase(item);

            EstoquePorClasseResponse retorno = new  EstoquePorClasseResponse(null, erroBase, null) ;

            return retorno;
        }
    }

    List<EstoquePorClasse> Painel() throws SQLException {

        DataSource ds = (DataSource)ac.getBean("dataSource");
        Connection c = ds.getConnection();


        String sql = "select * from local";

        sql = "SELECT c.id, c.nome ,sum(e.quantidade) quantidade FROM dbbuyer.estoque e join dbbuyer.local l on l.id=e.local_id join dbbuyer.usuario u on u.id=l.usuario_id join dbbuyer.material m on m.id=e.material_id join dbbuyer.produto p on p.id=m.produto_id join dbbuyer.classe c on c.id=p.classe_id where u.email='nandolrs.dev@gmail.com' group by c.id, c.nome ";

        Statement statement  = c.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<EstoquePorClasse> retorno = new ArrayList<>();
        while(rs.next())
        {
            Long id = rs.getLong("id");

            String nome =  rs.getString("nome");

            Float quantidade =  rs.getFloat("quantidade");

            EstoquePorClasse estoquePorClasse = new EstoquePorClasse();
            estoquePorClasse.setClasseId(id);
            estoquePorClasse.setClasseNome(nome);
            estoquePorClasse.setEstoqueQuantidade(quantidade);

            Long l = 0L;
            retorno.add(estoquePorClasse);

        }

        return retorno;
    }


}