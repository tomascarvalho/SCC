

import java.util.*;

// Classe que representa um servico com uma fila de espera associada

public class Servico 
{
    private String tipo;
    private int estado;                                     // Variavel que regista o estado do servico: 0 - livre; 1 - ocupado
    private int atendidos;                                  // Numero de clientes atendidos ate ao momento
    private double temp_ult, soma_temp_esp, soma_temp_serv; // Variaveis para calculos estatcsticos
    private Vector<Cliente> fila;                           // Fila de espera do servico
    private Simulador s;                                    // Referencia para o simulador a que pertence o servico
    private int n_empregados;
    
    // Construtor
    Servico (Simulador s, String tipo, int n_empregados)
    {
    	this.s = s;
        this.tipo = tipo;
        this.n_empregados = n_empregados;
        fila = new Vector <Cliente>();      // Cria fila de espera
        estado = 0;                         // Livre
        temp_ult = s.getInstante();         // Tempo que passou desde o ultimo evento. Neste caso 0, porque a simulacao ainda nao comecou.
        atendidos = 0;                      // Inicializacao de variaveis
        soma_temp_esp = 0;
        soma_temp_serv = 0;
    }

    // Metodo que insere cliente (c) no servico
    public void insereServico (Cliente c)
    {
        double media[];
        if (estado < n_empregados) // Se servico livre,
        { 
            estado ++;     // fica ocupado e
            // agenda saida do cliente c para daqui a s.getMedia_serv() instantes
            
            if(tipo.equals("loja"))
            {
                media = Aleatorio.normal(s.getMedia_serv_loja(),s.getDesvio_loja(),10);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else if(tipo.equals("selfservice"))
            {
                media = Aleatorio.normal(s.getMedia_serv_bomba(),s.getDesvio_bombas(),20);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else
            {
                media = Aleatorio.normal(s.getMedia_serv_bomba(),s.getDesvio_bombas(),30);
                s.insereEvento(new Transicao((s.getInstante()+media[0]),s,this));
            }
            
                       
        }
        else fila.addElement(c); // Se servico ocupado, o cliente vai para a fila de espera
    }

    // Metodo que remove cliente do servico
    public Cliente removeServico ()
    {
        Cliente c = null;
        double media[];
        atendidos++; // Regista que acabou de atender + 1 cliente
        if (fila.size()== 0)
        {
            // Se a fila esta vazia, liberta o servico
            estado --;
        } 
        else // Se nao,
        { 
            // vai buscar proximo cliente a fila de espera e
            c = (Cliente)fila.firstElement();
            fila.removeElementAt(0);
            // agenda a sua saida para daqui a s.getMedia_serv() instantes
            
            if(tipo.equals("loja"))
            {
                media = Aleatorio.normal(s.getMedia_serv_loja(),s.getDesvio_loja(),10);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else if(tipo.equals("selfservice"))
            {
                media = Aleatorio.normal(s.getMedia_serv_bomba(),s.getDesvio_bombas(),20);
                s.insereEvento (new Saida((s.getInstante()+media[0]),s,this));
            }
            else
            {
                media = Aleatorio.normal(s.getMedia_serv_bomba(),s.getDesvio_bombas(),30);
                s.insereEvento(new Transicao((s.getInstante()+media[0]),s,this));
            }
        }
        return c;
    }

    // Metodo que calcula valores para estatisticas, em cada passo da simulacao ou evento
    public void act_stats()
    {
        // Calcula tempo que passou desde o ultimo evento
        double temp_desde_ult = s.getInstante() - temp_ult;
        // Actualiza variavel para o proximo passo/evento
        temp_ult = s.getInstante();
        // Contabiliza tempo de espera na fila
        // para todos os clientes que estiveram na fila durante o intervalo
        soma_temp_esp += fila.size() * temp_desde_ult;
        // Contabiliza tempo de atendimento
        soma_temp_serv += estado * temp_desde_ult;
    }

    // Metodo que calcula valores finais estatisticos
    public void relat ()
    {
        // Tempo medio de espera na fila
        double temp_med_fila = soma_temp_esp / (atendidos+fila.size());
        // Comprimento medio da fila de espera
        // s.getInstante() neste momento e o valor do tempo de simulacao,
        // uma vez que a simulacao comecou em 0 e este metodo so e chamdo no fim da simulacao
        double comp_med_fila = soma_temp_esp / s.getInstante();
        // Tempo m�dio de atendimento no servico
        double utilizacao_serv = soma_temp_serv / s.getInstante();
        // Apresenta resultados
        
        System.out.println("------- "+tipo.toUpperCase()+" -------\n");
        if(tipo.equals("loja") && s.getCenario() == 1)
        {
            s.label_temp_medio_espera_loja.setText(s.label_temp_medio_espera_loja.getText()+temp_med_fila);
            s.label_comp_medio_fila_loja.setText(s.label_comp_medio_fila_loja.getText()+comp_med_fila);
            s.label_util_serv_loja.setText(s.label_util_serv_loja.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_loja.setText(s.label_temp_sim_loja.getText()+s.getInstante());
            s.label_n_client_atend_loja.setText(s.label_n_client_atend_loja.getText()+atendidos);
            s.label_n_client_fila_loja.setText(s.label_n_client_fila_loja.getText()+fila.size());
        }
        else if(tipo.equals("gasolina") && s.getCenario() == 1)
        {
            s.label_temp_medio_espera_gasolina.setText(s.label_temp_medio_espera_gasolina.getText()+temp_med_fila);
            s.label_comp_medio_fila_gasolina.setText(s.label_comp_medio_fila_gasolina.getText()+comp_med_fila);
            s.label_util_serv_gasolina.setText(s.label_util_serv_gasolina.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_gasolina.setText(s.label_temp_sim_gasolina.getText()+s.getInstante());
            s.label_n_client_atend_gasolina.setText(s.label_n_client_atend_gasolina.getText()+atendidos);
            s.label_n_client_fila_gasolina.setText(s.label_n_client_fila_gasolina.getText()+fila.size());
        }
        else if(tipo.equals("gasoleo") && s.getCenario() == 1)
        {
            s.label_temp_medio_espera_gasoleo.setText(s.label_temp_medio_espera_gasoleo.getText()+temp_med_fila);
            s.label_comp_medio_fila_gasoleo.setText(s.label_comp_medio_fila_gasoleo.getText()+comp_med_fila);
            s.label_util_serv_gasoleo.setText(s.label_util_serv_gasoleo.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_gasoleo.setText(s.label_temp_sim_gasoleo.getText()+s.getInstante());
            s.label_n_client_atend_gasoleo.setText(s.label_n_client_atend_gasoleo.getText()+atendidos);
            s.label_n_client_fila_gasoleo.setText(s.label_n_client_fila_gasoleo.getText()+fila.size());
        }
        else if(tipo.equals("selfservice") && s.getCenario() == 2)
        {
            s.label_temp_medio_espera_gasolina.setText(s.label_temp_medio_espera_gasolina.getText()+temp_med_fila);
            s.label_comp_medio_fila_gasolina.setText(s.label_comp_medio_fila_gasolina.getText()+comp_med_fila);
            s.label_util_serv_gasolina.setText(s.label_util_serv_gasolina.getText()+(utilizacao_serv/n_empregados));
            s.label_temp_sim_gasolina.setText(s.label_temp_sim_gasolina.getText()+s.getInstante());
            s.label_n_client_atend_gasolina.setText(s.label_n_client_atend_gasolina.getText()+atendidos);
            s.label_n_client_fila_gasolina.setText(s.label_n_client_fila_gasolina.getText()+fila.size());
        }
        System.out.println("Tempo medio de espera "+temp_med_fila);
        System.out.println("Comp. medio da fila "+comp_med_fila);
        System.out.println("Utilizacao do servico "+utilizacao_serv/n_empregados);
        System.out.println("Tempo de simulacao "+s.getInstante()); // Valor actual
        System.out.println("Numero de clientes atendidos "+atendidos);
        System.out.println("Numero de clientes na fila "+fila.size()); // Valor actual
    }

    // Metodo que devolve o numero de clientes atendidos no servico ate ao momento
    public int getAtendidos() 
    {
        return atendidos;
    }

    public String getTipo()
    {
        return tipo;
    }
}