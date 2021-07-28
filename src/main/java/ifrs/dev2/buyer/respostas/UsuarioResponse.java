package ifrs.dev2.buyer.respostas;

import ifrs.dev2.buyer.dados.Usuario;
import java.util.List;

public class UsuarioResponse {


        private ifrs.dev2.buyer.dados.Usuario    dados;
        private List<Usuario> dadosLista;
        private ifrs.dev2.buyer.erros.ErroBase  erro;

        public UsuarioResponse(ifrs.dev2.buyer.dados.Usuario _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Usuario> _dadosLista)
        {
            setDados(_dados);
            setDadosLista(_dadosLista);
            setErro(_erro);
        }

        public ifrs.dev2.buyer.dados.Usuario getDados() {return dados;
        }

        public void setDados(ifrs.dev2.buyer.dados.Usuario dados) {
            this.dados = dados;
        }

        public List<ifrs.dev2.buyer.dados.Usuario> getDadosLista() {
            return dadosLista;
        }

        public void setDadosLista(List<ifrs.dev2.buyer.dados.Usuario> dadosLista) {
            this.dadosLista = dadosLista;
        }

        public ifrs.dev2.buyer.erros.ErroBase getErro() {return erro;
        }

        public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
            this.erro = erro;
        }
    }


//