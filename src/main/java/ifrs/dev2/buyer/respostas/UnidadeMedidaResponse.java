package ifrs.dev2.buyer.respostas;

import ifrs.dev2.buyer.dados.UnidadeMedida;

import java.util.List;

public class UnidadeMedidaResponse {

        private ifrs.dev2.buyer.dados.UnidadeMedida     dados;
        private List<UnidadeMedida> dadosLista;
        private ifrs.dev2.buyer.erros.ErroBase  erro;

        public UnidadeMedidaResponse(ifrs.dev2.buyer.dados.UnidadeMedida _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.UnidadeMedida> _dadosLista)
        {
            setDados(_dados);
            setDadosLista(_dadosLista);
            setErro(_erro);
        }

        public ifrs.dev2.buyer.dados.UnidadeMedida getDados() {
            return dados;
        }

        public void setDados(ifrs.dev2.buyer.dados.UnidadeMedida dados) {
            this.dados = dados;
        }

        public List<ifrs.dev2.buyer.dados.UnidadeMedida> getDadosLista() {
            return dadosLista;
        }

        public void setDadosLista(List<ifrs.dev2.buyer.dados.UnidadeMedida> dadosLista) {
            this.dadosLista = dadosLista;
        }

        public ifrs.dev2.buyer.erros.ErroBase getErro() {
            return erro;
        }

        public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
            this.erro = erro;
        }
    }


