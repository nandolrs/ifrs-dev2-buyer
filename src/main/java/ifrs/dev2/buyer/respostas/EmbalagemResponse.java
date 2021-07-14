package ifrs.dev2.buyer.respostas;

import java.util.List;

public class EmbalagemResponse {

    private ifrs.dev2.buyer.dados.Embalagem     dados;
    private List<ifrs.dev2.buyer.dados.Embalagem>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public EmbalagemResponse(ifrs.dev2.buyer.dados.Embalagem _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Embalagem> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Embalagem getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Embalagem dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Embalagem> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Embalagem> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
