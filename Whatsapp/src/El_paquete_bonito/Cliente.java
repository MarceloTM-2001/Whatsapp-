/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package El_paquete_bonito;

import javax.swing.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lenovo
 */
public class Cliente {
    public static void main (String[] args){
        
        MarcoCliente mimarco=new MarcoCliente();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
class MarcoCliente extends JFrame{
    public MarcoCliente(){
        setBounds(600,300,280,350);
        
        LaminaMarcoCliente milamina = new LaminaMarcoCliente();
        
        add(milamina);
        setVisible(true);
    }
}

class LaminaMarcoCliente extends JPanel{
    public LaminaMarcoCliente(){
        
        JLabel texto = new JLabel("CLIENTE");
        add(texto);
        
        campo1=new JTextField(20);
        add(campo1);
        
        miboton=new JButton("Enviar");
        EnviarTexto mievento=new EnviarTexto();
        miboton.addActionListener(mievento);
                
        
        add(miboton);     
    }
    private class EnviarTexto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                Socket misocket = new Socket("192.168.1.76",5000);
                DataOutputStream flujoSalida= new DataOutputStream(misocket.getOutputStream());
                System.out.println("Mike");
                flujoSalida.writeUTF(campo1.getText());
                flujoSalida.close();
            }catch(UnknownHostException e1){
                e1.printStackTrace();
            }catch(IOException e1){
               System.out.println(e1.getMessage());
            }
        }
    }
    private JTextField campo1;
    private JButton miboton;   
}
