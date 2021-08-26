package ifrs.dev2.buyer.segurancas;

import ifrs.dev2.buyer.dados.Usuario;
import ifrs.dev2.buyer.dados.UsuarioAutenticador;
import ifrs.dev2.buyer.repositorios.UsuarioAutenticadorRepository;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import java.util.Calendar;

public class Cripto {

//    @Autowired
//    private UsuarioAutenticadorRepository repositorioUsuarioAutenticador;

    static public String CifrarSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] senhaBaites = md.digest(senha.getBytes(StandardCharsets.UTF_8));

        //return senhaBaites.toString();
        return senha;
    }

    static public void TestarSenha() throws NoSuchAlgorithmException {
        String senhaFechada = CifrarSenha("deu merda");
    }

    static public Usuario Token2Usuario(HttpHeaders headers,  UsuarioAutenticadorRepository repositorioUsuarioAutenticador) //
    {
        Usuario retorno = null;

        String sessao = headers.getFirst("token");

        if(sessao.equals(""))
        {
            return retorno;
        }
        Optional <UsuarioAutenticador>  usuarioAutenticador = repositorioUsuarioAutenticador.findBySessao(sessao);

        // atualiza o ultimo acesso da sessao

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.add(Calendar.HOUR_OF_DAY,24);
        Date dataFutura = calendario.getTime();

        usuarioAutenticador.get().setTempoSessao(dataFutura);
        repositorioUsuarioAutenticador.save(usuarioAutenticador.get());

        //

        retorno = usuarioAutenticador.get().getUsuario();

        return retorno;
    }
}
