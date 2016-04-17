/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto.pkg2016;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author freitas
 */
public class InitSimulador 
{
    public static ArrayList <String> run()
    {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        ArrayList<String> list = new ArrayList<>();
        JTextField tempo_execucao = new JTextField("");
        JTextField intervalo_chegada = new JTextField("");
        JTextField tempo_atendimento_bomba = new JTextField("");
        JTextField tempo_atendimento_loja = new JTextField("");
        JTextField n_loja = new JTextField("");
        JTextField n_gasolina = new JTextField("");
        JTextField n_gasoleo = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JLabel("Tempo de execucao:"));
        panel.add(tempo_execucao);
        panel.add(new JLabel("Intervalo de chegada dos clientes:"));
        panel.add(intervalo_chegada);
        panel.add(new JLabel("Tempo medio de atendimento nas bombas:"));
        panel.add(tempo_atendimento_bomba);
        panel.add(new JLabel("Tempo medio de atendimento na loja:"));
        panel.add(tempo_atendimento_loja);
        panel.add(new JLabel("Numero de funcionarios na loja:"));
        panel.add(n_loja);
        panel.add(new JLabel("Numero de funcionarios na bomba de gasolina:"));
        panel.add(n_gasolina);
        panel.add(new JLabel("Numero de funcionarios na bomba de gasoleo:"));
        panel.add(n_gasoleo);
        int result = JOptionPane.showConfirmDialog(null, panel,"Configuracao do Simulador",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION)
        {
            if(!"".equals(tempo_execucao.getText()) && !"".equals(intervalo_chegada.getText()) && !"".equals(tempo_atendimento_bomba.getText()) && !"".equals(tempo_atendimento_loja.getText()) && 
                    !"".equals(n_loja.getText()) && !"".equals(n_gasolina.getText()) && !"".equals(n_gasoleo.getText()))
            {
                list.add(tempo_execucao.getText());
                list.add(intervalo_chegada.getText());
                list.add(tempo_atendimento_bomba.getText());
                list.add(tempo_atendimento_loja.getText());
                list.add(n_loja.getText());
                list.add(n_gasolina.getText());
                list.add(n_gasoleo.getText());
                try
                {
                    for(int i=0;i<list.size();i++)
                    {
                        Double.parseDouble(list.get(i));
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Por favor coloque apenas números!");
                    run();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
                run();
            }    
            
        }
        else
        {
            System.exit(0);
        }
        return list;
    }
}
