package projecto.pkg2016;

public class Simulador 
{
    // Relogio de simulacao - variavel que contem o valor do tempo em cada instante
    private double instante;
    // Medias das distribuicoes de chegadas e de atendimento no servico
    private double media_cheg, media_serv_bomba;
    // Numero de clientes que vao ser atendidos
    private int n_clientes;
    // Servico - pode haver mais do que um num simulador
    private Servico servico_gasolina;
    
    private Servico servico_loja;
    // Lista de eventos - onde ficam registados todos os eventos que vao ocorrer na simulacao
    // Cada simulador so tem uma
    private ListaEventos lista;
    
    private double instante_final;

    private double media_serv_loja;
    // Construtor
    public Simulador() 
    {
        // Inicializacao de parametros do simulador
        media_cheg = 1.2;
        media_serv_bomba = 4;
        media_serv_loja = 1;
        n_clientes = 100;
        // Inicializacao do relogio de simulacao
        instante = 0;
        instante_final = 11;
        // Criacao do servico
        servico_gasolina = new Servico (this,"gasolina");
        servico_loja = new Servico(this,"loja");
        // Criacao da lista de eventos
        lista = new ListaEventos(this);
        // Agendamento da primeira chegada
        // Se nao for feito, o simulador nao tem eventos para simular
        insereEvento (new Chegada(instante, this, servico_gasolina));
    }

    // programa principal
    public static void main(String[] args) 
    {
        // Cria um simulador e
        Simulador s = new Simulador();
        // poe-o em marcha
        s.executa();
    }

    // Metodo que insere o evento e1 na lista de eventos
    void insereEvento (Evento e1)
    {
        lista.insereEvento (e1);
    }

    // Metodo que actualiza os valores estatisticos do simulador
    private void act_stats()
    {
        servico_gasolina.act_stats();
        servico_loja.act_stats();
    }

    // Metodo que apresenta os resultados de simulacao finais
    private void relat ()
    {
        System.out.println();
        System.out.println("------- Resultados finais -------");
        System.out.println();
        servico_gasolina.relat();
        System.out.println();
        servico_loja.relat();
    }

    // Metodo executivo do simulador
    public void executa ()
    {
        Evento e1;
        // Enquanto não chegar ao instante final
        while (instante < instante_final)
        {
            //lista.print();                     // Mostra lista de eventos - desnecessario; e apenas informativo
            e1 = (Evento)(lista.removeFirst());  // Retira primeiro evento (e o mais iminente) da lista de eventos
            //System.out.println(e1.toString());
            instante = e1.getInstante();         // Actualiza relogio de simulacao
            act_stats();                         // Actualiza valores estatisticos
            e1.executa();
        }
        relat();  // Apresenta resultados de simulacao finais
    }

    // Metodo que devolve o instante de simulacao corrente
    public double getInstante()
    {
        return instante;
    }

    // Metodo que devolve a media dos intervalos de chegada
    public double getMedia_cheg()
    {
        return media_cheg;
    }

    // Metodo que devolve a media dos tempos de servico
    public double getMedia_serv_bomba()
    {
        return media_serv_bomba;
    }

    public double getMedia_serv_loja() 
    {
        return media_serv_loja;
    }

    public Servico getServico_loja() 
    {
        return servico_loja;
    }
    
    
    
}