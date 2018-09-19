/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import javax.swing.JOptionPane;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import models.ModelBloc;
    import views.ViewBlocNotas;
/**
 *
 * @author Octaviano
 */
public class ControllerBloc {
   ModelBloc modelBlock;
   ViewBlocNotas vieBlocNotas;
   
   ActionListener al = new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e) {
          if(e.getSource()== vieBlocNotas.jmi_leer) jmi_leer_action_performed();
          if(e.getSource()== vieBlocNotas.jmi_guardar) jmi_esribir_action_performed();   
       }   
   };

    public ControllerBloc(ModelBloc modelBlock, ViewBlocNotas vieBlocNotas) {
        vieBlocNotas.setVisible(true);
        this.modelBlock = modelBlock;
        this.vieBlocNotas = vieBlocNotas;
        this.vieBlocNotas.jmi_leer.addActionListener(al);
        this.vieBlocNotas.jmi_guardar.addActionListener(al);
    }
    /**
     * En este metodo se llama al metodo de readFile 
     * y se le agrega su parametro para que pueda realizar su funcion de manera correcta
     * @param path 
     */
    public void jmi_leer_action_performed(){
        this.readFile(modelBlock.getPath());
    }
    /**
     * En este metodo se llama al metodo de writeFile
     * y se le agrega su parametro para que pueda realizar su funcion de manera correcta
     */
    public void jmi_esribir_action_performed(){
        this.writeFile( modelBlock.getPath(), modelBlock.getMessage());
    }
    /**
     * En este metodo se lee un archivo
     * El archivo se vera en un TextArea 
     * @param path 
     */
    public String readFile(String path){
        try{
            String row; // indica una fila
            try (FileReader file = new FileReader(path)) {
                BufferedReader bufferedReader = new BufferedReader(file);
                while ((row=bufferedReader.readLine())!= null){
                    vieBlocNotas.jta_contenido.setText(row); //abre el archivo en la TextArea
                    //row=bufferedReader.readLine(); // si el archivo tiene mas filas con esta linea ira mostrando cada una de ellas
                }
                bufferedReader.close();
        } catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null,"File not found"+err.getMessage());
        }
            
        } catch(IOException err){
            JOptionPane.showMessageDialog(null,"error on IO operation:"+err.getMessage());
        } 
       return null;
        
    }//ReadFile    
    /**
     * Escribe nuevas lineas en el archivo
     */
    public String writeFile (String path, String message) {
        try{
            File  file = new File(path); //Ruta del arhivo que se abrira
            FileWriter fileWriter = new FileWriter(file,true);  
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){               
                printWriter.println(vieBlocNotas.jta_contenido.getText());
                printWriter.close();                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"File not found:"+e.getMessage());
        }
        }catch(IOException err){
            JOptionPane.showMessageDialog(null,"error on IO operation:"+err.getMessage());
        } 
       return null;   
    }//WriteFile    
}//class
