package projecto.pkg2016;

// Classe que representa a chegada de um cliente. Deriva de Evento.

public class Chegada extends Evento 
{

    //Construtor
    
    Chegada (double i, Simulador s, Servico tipo)
    {
        super (i, s, tipo);
    }
    
    // Metodo que executa as accoes correspondentes a chegada de um cliente
    void executa ()
    {
	// Coloca cliente no servico - na fila ou a ser atendido, conforme o caso
        tipo.insereServico (new Cliente());
        // Agenda nova chegada para daqui a Aleatorio.exponencial(s.media_cheg) instantes
        s.insereEvento (new Chegada(s.getInstante()+Aleatorio.exponencial(s.getMedia_cheg()), s,tipo));
    }

    // Metodo que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString()
    {
        return "Chegada em " + instante;
    }
}