/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Carrera extends Thread {
    
    private JLabel etiqueta;
    private f_Carrera auto;
    
         FileWriter resultados;
    
    public Carrera(JLabel etiqueta, f_Carrera auto) throws IOException {
        this.resultados = new FileWriter("C:/Users/diego/Documents/NetBeansProjects/resultados.txt"); // el FileWriter es el encargado de la persistencia de datos, pueden cambiar la ruta a donde deseen
        this.etiqueta = etiqueta;
        this.auto = auto;
    }
    
    @Override
    public void run(){
        
        int auto1 = 0;
        int auto2 = 0;
        
         while(true){
             try{
                 
                  sleep((int)(Math.random() * 1000));
                  auto1 = auto.getCarro1().getLocation().x;
                  auto2 = auto.getCarro2().getLocation().x;
                  
                  if(auto1 < auto.getMeta().getLocation().x - 125 && auto2 < auto.getMeta().getLocation().x - 125){
                      etiqueta.setLocation(etiqueta.getLocation().x + 10,etiqueta.getLocation().y);
                      auto.repaint();
                  }else{
                      break;
                  }
                  
             }catch(InterruptedException e){
                 System.out.println(e);
             }
            
             if(etiqueta.getLocation().x >= auto.getMeta().getLocation().x - 125){
                  if(auto1 > auto2){
                      JOptionPane.showMessageDialog(null,"Gano el primer auto");
                      try {
                          resultados.write("ganó el primer carro");
                      } catch (IOException ex) {
                          Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      try {
                          resultados.close();
                      } catch (IOException ex) {
                          Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
                  else if(auto2 > auto1){
                      JOptionPane.showMessageDialog(null,"Gano el segundo auto");
                       try {
                          resultados.write("ganó el segundo");
                      } catch (IOException ex) {
                          Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      try {
                          resultados.close();
                      } catch (IOException ex) {
                          Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"Empate");
                       try {
                          resultados.write("empataron");
                      } catch (IOException ex) {
                          Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
             }
                   
        } 
    }
    
}
