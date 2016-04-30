/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        JTextField intervalo_chegada = new JTextField("1.2");
        JTextField tempo_atendimento_bomba = new JTextField("4");
        JTextField desvio_bomba = new JTextField("2.5");
        JTextField tempo_atendimento_loja = new JTextField("1");
        JTextField desvio_loja = new JTextField("0.5");
        JTextField n_loja = new JTextField("1");
        JTextField n_gasolina = new JTextField("2");
        JTextField n_gasoleo = new JTextField("1");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton cenario_1 = new JRadioButton("Cenario 1",true);
        JRadioButton cenario_2 = new JRadioButton("Cenario 2",false);
        buttonGroup.add(cenario_1);
        buttonGroup.add(cenario_2);
        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JLabel("Tempo de execucao:"));
        panel.add(tempo_execucao);
        panel.add(new JLabel("Intervalo de chegada dos clientes:"));
        panel.add(intervalo_chegada);
        panel.add(new JLabel("Tempo medio de atendimento nas bombas:"));
        panel.add(tempo_atendimento_bomba);
        panel.add(new JLabel("Desvio padrão nas bombas:"));
        panel.add(desvio_bomba);
        panel.add(new JLabel("Tempo medio de atendimento na loja:"));
        panel.add(tempo_atendimento_loja);
        panel.add(new JLabel("Desvio padrão na loja:"));
        panel.add(desvio_loja);
        panel.add(new JLabel("Numero de funcionarios na loja:"));
        panel.add(n_loja);
        panel.add(new JLabel("Numero de funcionarios na bomba de gasolina:"));
        panel.add(n_gasolina);
        panel.add(new JLabel("Numero de funcionarios na bomba de gasoleo:"));
        panel.add(n_gasoleo);
        panel.add(cenario_1);
        panel.add(cenario_2);
        int result = JOptionPane.showConfirmDialog(null, panel,"Configuracao do Simulador",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION)
        {
            if(!"".equals(tempo_execucao.getText()) && !"".equals(intervalo_chegada.getText()) && !"".equals(tempo_atendimento_bomba.getText()) && !"".equals(tempo_atendimento_loja.getText()) && 
                    !"".equals(n_loja.getText()) && !"".equals(n_gasolina.getText()) && !"".equals(n_gasoleo.getText()) && !"".equals(desvio_bomba.getText()) && !"".equals(desvio_loja.getText()))
            {
                list.add(tempo_execucao.getText());
                list.add(intervalo_chegada.getText());
                list.add(tempo_atendimento_bomba.getText());
                list.add(tempo_atendimento_loja.getText());
                list.add(n_loja.getText());
                list.add(n_gasolina.getText());
                list.add(n_gasoleo.getText());
                list.add(desvio_bomba.getText());
                list.add(desvio_loja.getText());
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
                if(cenario_1.isSelected()==true)
                {
                    list.add("1");
                }
                else if(cenario_2.isSelected()==true)
                {
                    list.add("2");
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
