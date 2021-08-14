package ifrs.dev2.buyer.respostas;

import ifrs.dev2.buyer.dados.ReceitaMaterial;

import java.util.List;

public class ReceitaMaterialResponse {
    private ifrs.dev2.buyer.dados.ReceitaMaterial dados;
    private List<ReceitaMaterial> dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase erro;

    public ReceitaMaterialResponse(ReceitaMaterial _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ReceitaMaterial> _dadosLista) {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ReceitaMaterial getDados() {
        return dados;
    }

    public void setDados(ReceitaMaterial dados) {
        this.dados = dados;
    }

    public List<ReceitaMaterial> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ReceitaMaterial> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}


