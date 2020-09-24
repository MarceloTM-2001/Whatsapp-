/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package El_paquete_bonito;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author Lenovo
 */
public class Servidor {
    public static void main(String[] args){
        MarcoServidor mimarco = new MarcoServidor();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
}

class MarcoServidor extends JFrame implements Runnable{
    public MarcoServidor(){     
        setBounds(1200,300,280,350);
        
        JPanel milamina= new JPanel();
        milamina.setLayout(new BorderLayout());
        System.out.println("Esto");
        areatexto = new JTextArea();
        milamina.add(areatexto,BorderLayout.CENTER);
        add(milamina);
        
        setVisible(true);
        
        Thread mihilo = new Thread(this);
        mihilo.start();
        
    }
    private JTextArea areatexto;
    @Override
    public void run(){
        try{
            ServerSocket servidor =new ServerSocket(5000);
        
            Socket misocket = servidor.accept();
        
            DataInputStream flujoEntrada = new DataInputStream(misocket.getInputStream());
            
            String mensaje_texto=flujoEntrada.readUTF();
            
            areatexto.append("/n"+ mensaje_texto);
            misocket.close(); 
        }catch(IOException e){
            e.printStackTrace();
        }
    }       
}