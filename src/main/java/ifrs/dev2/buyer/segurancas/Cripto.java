package ifrs.dev2.buyer.segurancas;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cripto {

    static public String CifrarSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] senhaBaites = md.digest(senha.getBytes(StandardCharsets.UTF_8));

        return senhaBaites.toString();
    }

    static public void TestarSenha() throws NoSuchAlgorithmException {
        String senhaFechada = CifrarSenha("deu merda");
    }
}
