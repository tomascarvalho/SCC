

// Classe que representa a saida de um cliente. Deriva de Evento.

public class Saida extends Evento 
{
    //Construtor
    
    Saida (double i, Simulador s, Servico tipo)
    {
        super(i, s, tipo);
    }

    // Metodo que executa as accoes correspondentes a saida de um cliente
    void executa ()
    {
        // Retira cliente do servico
        tipo.removeServico();
    }

    // Metodo que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString()
    {
         return "Saida em " + instante + " do tipo " + tipo;
    }
}