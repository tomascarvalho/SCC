package projecto.pkg2016;

// Classe que representa um cliente
// Como sao indistintos neste exemplo, esta vazia

public class Cliente 
{
    private int tipo;
    private String local;
    
    Cliente(int tipo, String local)
    {
        this.tipo = tipo;
        this.local = local;
    }

    public int getTipo() 
    {
        return tipo;
    }

    public String getLocal() 
    {
        return local;
    }

    public void setLocal(String local) 
    {
        this.local = local;
    }
    
    
}