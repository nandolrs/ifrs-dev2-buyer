package ifrs.dev2.buyer.erros;

import java.lang.reflect.Array;

public class Erro extends  Exception {

    ErroItem[] itens;
    Exception exception;

    public Erro()
    {

    }

    public Erro(Exception e)
    {
        exception = e;
    }

    public Erro(ErroItem erroItem)
    {
        itens = new ErroItem[1];
        itens[0] = erroItem;
    }

    public void Adicionar(ErroItem erroItem)
    {
        int  tam = itens.length+1;

        ErroItem[] itensDestino = new ErroItem[tam];

        java.lang.System.arraycopy(itens,0, itensDestino,0,tam);
        itensDestino[tam-1] = erroItem;
        itens = itensDestino;
    }
}
