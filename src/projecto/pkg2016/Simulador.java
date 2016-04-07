package projecto.pkg2016;

public class Simulador {

 	// Relogio de simulacao - variavel que contem o valor do tempo em cada instante
    private double instante;
    // M�dias das distribuicoes de chegadas e de atendimento no servico
	private double media_cheg, media_serv;
	// N�mero de clientes que vao ser atendidos
	private int n_clientes;
	// Servi�o - pode haver mais do que um num simulador
    private Servico servico;
    // Lista de eventos - onde ficam registados todos os eventos que vao ocorrer na simula��o
    // Cada simulador so tem uma
	private ListaEventos lista;

    // Construtor
    public Simulador() {
		// Inicializacao de parametros do simulador
        media_cheg = 1;
		media_serv = 1.5;
		n_clientes = 100;
		// Inicializacao do relogio de simulacao
		instante = 0;
		// Criacao do servico
		servico = new Servico (this);
		// Criacao da lista de eventos
		lista = new ListaEventos(this);
		// Agendamento da primeira chegada
        // Se nao for feito, o simulador nao tem eventos para simular
		insereEvento (new Chegada(instante, this));
    }

        // programa principal
        public static void main(String[] args) {
            // Cria um simulador e
            Simulador s = new Simulador();
            // p�e-o em marcha
            s.executa();
        }

    // M�todo que insere o evento e1 na lista de eventos
	void insereEvento (Evento e1){
		lista.insereEvento (e1);
	}

    // M�todo que actualiza os valores estat�sticos do simulador
	private void act_stats(){
		servico.act_stats();
	}

    // M�todo que apresenta os resultados de simula��o finais
	private void relat (){
    	System.out.println();
    	System.out.println("------- Resultados finais -------");
    	System.out.println();
		servico.relat();
	}

    // Metodo executivo do simulador
	public void executa (){
		Evento e1;
		// Enquanto nao atender todos os clientes
		while (servico.getAtendidos() < n_clientes){
    	//	lista.print();  // Mostra lista de eventos - desnecessario; e apenas informativo
			e1 = (Evento)(lista.removeFirst());  // Retira primeiro evento (e o mais iminente) da lista de eventos
			instante = e1.getInstante();         // Actualiza relogio de simulacao
			act_stats();                         // Actualiza valores estatisticos
			e1.executa(servico);                 // Executa evento
		};
		relat();  // Apresenta resultados de simula��o finais
	}

    // M�todo que devolve o instante de simula��o corrente
    public double getInstante() {
        return instante;
    }

    // M�todo que devolve a m�dia dos intervalos de chegada
    public double getMedia_cheg() {
        return media_cheg;
    }

    // M�todo que devolve a m�dia dos tempos de servi�o
    public double getMedia_serv() {
        return media_serv;
    }

}