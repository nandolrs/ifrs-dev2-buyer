package ifrs.dev2.buyer.respostas;

import java.util.List;

public class MaterialResponse {

    private ifrs.dev2.buyer.dados.Material     dados;
    private List<ifrs.dev2.buyer.dados.Material>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public MaterialResponse(ifrs.dev2.buyer.dados.Material _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Material> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Material getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Material dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Material> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Material> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
