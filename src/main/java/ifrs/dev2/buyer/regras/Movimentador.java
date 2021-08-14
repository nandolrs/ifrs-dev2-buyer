package ifrs.dev2.buyer.regras;

import ifrs.dev2.buyer.dados.Estoque;
import ifrs.dev2.buyer.dados.Movimento;

import ifrs.dev2.buyer.repositorios.LocalRepository;
import ifrs.dev2.buyer.repositorios.MaterialRepository;
import ifrs.dev2.buyer.repositorios.EstoqueRepository;

import java.util.List;

public class Movimentador {
    LocalRepository localRepositorio;
    MaterialRepository materialRepositorio;
    EstoqueRepository estoqueRepositorio;

    public Movimentador(LocalRepository _localRepositorio
            ,MaterialRepository _materialRepositorio
            ,EstoqueRepository _estoqueRepositorio

    )
    {
        localRepositorio =  _localRepositorio;
        materialRepositorio =  _materialRepositorio;
        estoqueRepositorio =  _estoqueRepositorio;
    }

    public void Movimentar(Movimento movimento) throws Exception {
        /*
        List<Estoque> estoque = estoqueRepositorio.findByXXX(
                movimento.getLocal().getId()
                , movimento.getMaterial().getId()
        );
*/
        // busca estoque atual

        Estoque estoqueAtual = new Estoque();

        //Long localId = movimento.getLocal().getId();
        //Long materialId = movimento.getMaterial().getId();

        List<Estoque> estoqueAtualLista = estoqueRepositorio.PesquisarPorLocalEMaterial(movimento.getLocal().getId()
                , movimento.getMaterial().getId()
        );

        if (estoqueAtualLista.size() > 0) // existe
        {
            estoqueAtual = estoqueAtualLista.get(0);
        }
        else
        {
            estoqueAtual.setLocal(movimento.getLocal());
            estoqueAtual.setMaterial(movimento.getMaterial());
            estoqueAtual.setQuantidade(0F);
        }

        // calcula novo estoque

        if (movimento.getTipo() == 1) // entrada
        {
            estoqueAtual.setQuantidade(estoqueAtual.getQuantidade() + movimento.getQuantidade());
        } else  if (movimento.getTipo() == 2) // saida
        {
            estoqueAtual.setQuantidade(estoqueAtual.getQuantidade() - movimento.getQuantidade());
        } else if(movimento.getTipo() == 3) // compra
        {
            estoqueAtual.setQuantidade(estoqueAtual.getQuantidade() + movimento.getQuantidade());
        } else if(movimento.getTipo() == 4) // cotacao
        {
            // nao movimenta
        } else
        {
            throw new Exception("Tipo do movimento invalido.");
        }

        // salva o novo estoque

        estoqueRepositorio.save(estoqueAtual);

    }

}
