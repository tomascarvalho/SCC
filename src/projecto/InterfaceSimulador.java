/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author freitas
 */
public class InterfaceSimulador extends JFrame
{
    protected JPanel panel_loja;
    protected JPanel panel_gasolina;
    protected JPanel panel_gasoleo;
    protected JPanel box_panel_loja;
    protected JPanel box_panel_gasolina;
    protected JPanel box_panel_gasoleo;
    protected JLabel label_temp_medio_espera_loja;
    protected JLabel label_temp_medio_espera_gasolina;
    protected JLabel label_temp_medio_espera_gasoleo;
    protected JLabel label_comp_medio_fila_loja;
    protected JLabel label_comp_medio_fila_gasolina;
    protected JLabel label_comp_medio_fila_gasoleo;
    protected JLabel label_util_serv_loja;
    protected JLabel label_util_serv_gasolina;
    protected JLabel label_util_serv_gasoleo;
    protected JLabel label_temp_sim_loja;
    protected JLabel label_temp_sim_gasolina;
    protected JLabel label_temp_sim_gasoleo;
    protected JLabel label_n_client_atend_loja;
    protected JLabel label_n_client_atend_gasolina;
    protected JLabel label_n_client_atend_gasoleo;
    protected JLabel label_n_client_fila_loja;
    protected JLabel label_n_client_fila_gasolina;
    protected JLabel label_n_client_fila_gasoleo;
    protected JTabbedPane tabbed_pane = new JTabbedPane();
    
    
    protected void initComponents(int cenario)
    {
        try
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e) 
        {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        setTitle("Simulador Bomba de Gasolina");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        panel_loja = new JPanel();
        panel_loja.setLayout(new BorderLayout());
        
        panel_gasolina = new JPanel();
        panel_gasolina.setLayout(new BorderLayout());
        
        panel_gasoleo = new JPanel();
        panel_gasoleo.setLayout(new BorderLayout());
        
        box_panel_loja = new JPanel();
        box_panel_loja.setLayout(new BoxLayout(box_panel_loja,BoxLayout.PAGE_AXIS));
        
        label_temp_medio_espera_loja = new JLabel("Tempo medio de espera: ");
        box_panel_loja.add(label_temp_medio_espera_loja);
        box_panel_loja.add(Box.createVerticalGlue());
        label_comp_medio_fila_loja = new JLabel("Comprimento medio da fila: ");
        box_panel_loja.add(label_comp_medio_fila_loja);
        box_panel_loja.add(Box.createVerticalGlue());
        label_util_serv_loja = new JLabel("Utilizacao do servico: ");
        box_panel_loja.add(label_util_serv_loja);
        box_panel_loja.add(Box.createVerticalGlue());
        label_temp_sim_loja = new JLabel("Tempo de simulacao: ");
        box_panel_loja.add(label_temp_sim_loja);
        box_panel_loja.add(Box.createVerticalGlue());
        label_n_client_atend_loja = new JLabel("Numero de clientes atendidos: ");
        box_panel_loja.add(label_n_client_atend_loja);
        box_panel_loja.add(Box.createVerticalGlue());
        label_n_client_fila_loja = new JLabel("Numero de clientes na fila: ");
        box_panel_loja.add(label_n_client_fila_loja);
        box_panel_loja.add(Box.createVerticalGlue());
        
        panel_loja.add(box_panel_loja,BorderLayout.CENTER);
        
        box_panel_gasolina = new JPanel();
        box_panel_gasolina.setLayout(new BoxLayout(box_panel_gasolina,BoxLayout.PAGE_AXIS));
        
        label_temp_medio_espera_gasolina = new JLabel("Tempo medio de espera: ");
        box_panel_gasolina.add(label_temp_medio_espera_gasolina,BorderLayout.CENTER);
        box_panel_gasolina.add(Box.createVerticalGlue());
        label_comp_medio_fila_gasolina = new JLabel("Comprimento medio da fila: ");
        box_panel_gasolina.add(label_comp_medio_fila_gasolina);
        box_panel_gasolina.add(Box.createVerticalGlue());
        label_util_serv_gasolina = new JLabel("Utilizacao do servico: ");
        box_panel_gasolina.add(label_util_serv_gasolina);
        box_panel_gasolina.add(Box.createVerticalGlue());
        label_temp_sim_gasolina = new JLabel("Tempo de simulacao: ");
        box_panel_gasolina.add(label_temp_sim_gasolina);
        box_panel_gasolina.add(Box.createVerticalGlue());
        label_n_client_atend_gasolina = new JLabel("Numero de clientes atendidos: ");
        box_panel_gasolina.add(label_n_client_atend_gasolina);
        box_panel_gasolina.add(Box.createVerticalGlue());
        label_n_client_fila_gasolina = new JLabel("Numero de clientes na fila: ");
        box_panel_gasolina.add(label_n_client_fila_gasolina);
        box_panel_gasolina.add(Box.createVerticalGlue());
        
        panel_gasolina.add(box_panel_gasolina,BorderLayout.CENTER);
        
        box_panel_gasoleo = new JPanel();
        box_panel_gasoleo.setLayout(new BoxLayout(box_panel_gasoleo,BoxLayout.PAGE_AXIS));
        
        label_temp_medio_espera_gasoleo = new JLabel("Tempo medio de espera: ");
        box_panel_gasoleo.add(label_temp_medio_espera_gasoleo,BorderLayout.CENTER);
        box_panel_gasoleo.add(Box.createVerticalGlue());
        label_comp_medio_fila_gasoleo = new JLabel("Comprimento medio da fila: ");
        box_panel_gasoleo.add(label_comp_medio_fila_gasoleo);
        box_panel_gasoleo.add(Box.createVerticalGlue());
        label_util_serv_gasoleo = new JLabel("Utilizacao do servico: ");
        box_panel_gasoleo.add(label_util_serv_gasoleo);
        box_panel_gasoleo.add(Box.createVerticalGlue());
        label_temp_sim_gasoleo = new JLabel("Tempo de simulacao: ");
        box_panel_gasoleo.add(label_temp_sim_gasoleo);
        box_panel_gasoleo.add(Box.createVerticalGlue());
        label_n_client_atend_gasoleo = new JLabel("Numero de clientes atendidos: ");
        box_panel_gasoleo.add(label_n_client_atend_gasoleo);
        box_panel_gasoleo.add(Box.createVerticalGlue());
        label_n_client_fila_gasoleo = new JLabel("Numero de clientes na fila: ");
        box_panel_gasoleo.add(label_n_client_fila_gasoleo);
        box_panel_gasoleo.add(Box.createVerticalGlue());
        
        panel_gasoleo.add(box_panel_gasoleo,BorderLayout.CENTER);

        if(cenario == 1)
        {
            tabbed_pane.addTab("Loja",panel_loja);
            tabbed_pane.addTab("Gasolina",panel_gasolina);
            tabbed_pane.addTab("Gasoleo",panel_gasoleo);
        }
        else if(cenario == 2)
        {
            tabbed_pane.addTab("Bombas Self-Service",panel_gasolina);
        }
        this.add(tabbed_pane);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }
    
    protected void refreshGUI()
    {
        this.revalidate();
    }
}
