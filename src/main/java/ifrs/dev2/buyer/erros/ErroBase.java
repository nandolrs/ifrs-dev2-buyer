package ifrs.dev2.buyer.erros;

public class ErroBase {

    ErroItem[] itens;
    Exception exception;

    public ErroBase(Exception e)
    {
        exception = e;
    }

    public ErroBase(ErroItem erroItem)
    {
        itens = new ErroItem[1];
        itens[0] = erroItem;
    }

    public ErroBase(Erro erro)
    {
        itens = new ErroItem[0];
        for(ErroItem item : erro.itens)
        {

            Adicionar(item);
        }
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


