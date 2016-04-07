package projecto.pkg2016;

// Classe que representa a saida de um cliente. Deriva de Evento.

public class Saida extends Evento {

	//Construtor
	Saida (double i, Simulador s){
		super(i, s);
	}

	// M�todo que executa as accoes correspondentes a saida de um cliente
	void executa (Servico serv){
		// Retira cliente do servico
        serv.removeServico();
    }

    // Metodo que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString(){
         return "Sa�da em " + instante;
    }


}