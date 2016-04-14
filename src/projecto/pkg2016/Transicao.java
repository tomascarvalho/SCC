/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.pkg2016;

/**
 *
 * @author freitas
 */
public class Transicao extends Evento
{

    public Transicao(double i, Simulador s, Servico tipo) 
    {
        super(i, s, tipo);
    }
    
    
    void executa() 
    {
        s.getServico_loja().insereServico(tipo.removeServico());
    }

    public String toString() 
    {
        return "Transicao de gasolina para a loja no instante "+s.getInstante();
    }
    
    
    
}
