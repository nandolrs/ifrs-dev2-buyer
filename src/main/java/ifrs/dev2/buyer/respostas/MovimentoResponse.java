package ifrs.dev2.buyer.respostas;

import ifrs.dev2.buyer.dados.Movimento;

import java.util.List;

public class MovimentoResponse {

        private ifrs.dev2.buyer.dados.Movimento     dados;
        private List<Movimento> dadosLista;
        private ifrs.dev2.buyer.erros.ErroBase  erro;

        public MovimentoResponse(ifrs.dev2.buyer.dados.Movimento _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Movimento> _dadosLista)
        {
            setDados(_dados);
            setDadosLista(_dadosLista);
            setErro(_erro);
        }

        public ifrs.dev2.buyer.dados.Movimento getDados() {
            return dados;
        }

        public void setDados(ifrs.dev2.buyer.dados.Movimento dados) {
            this.dados = dados;
        }

        public List<ifrs.dev2.buyer.dados.Movimento> getDadosLista() {
            return dadosLista;
        }

        public void setDadosLista(List<ifrs.dev2.buyer.dados.Movimento> dadosLista) {
            this.dadosLista = dadosLista;
        }

        public ifrs.dev2.buyer.erros.ErroBase getErro() {
            return erro;
        }

        public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
            this.erro = erro;
        }
    }


