/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Main;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author joseg
 */
public class Archivo {
    
    public Archivo(){}
    
    public String Guardar_como(String texto) throws IOException
    {
        String path=" ";
        JFileChooser escoger= new JFileChooser("D:\\Codigos\\Proyectos de JAVA\\analizador_cadenas");
        escoger.setApproveButtonText("Guardar Como"); 
        escoger.showOpenDialog(escoger); 
        File archivo= new File(escoger.getSelectedFile()+".txt");
        FileWriter escribir= new FileWriter(archivo,true);
        PrintWriter imprimir=new PrintWriter(escribir);
        
            imprimir.println(texto);
            imprimir.close();
        path=archivo.getPath();
        return path;
        }
    
    public String Guardar(String texto, String nombre) throws IOException
    {
        
        String nombre_archivo=nombre;
        File archivo1=new File(nombre_archivo);
        FileWriter escribir;
        PrintWriter imprimir;
        if(!archivo1.exists())
        {
        if(nombre.isBlank())
        { 
            nombre=Guardar_como(texto); 
        }
        }
        else
        {
            try
            {
                escribir=new FileWriter(archivo1);
                imprimir=new PrintWriter(escribir);
                
                imprimir.println(texto);
                imprimir.close();
                escribir.close();
            }catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Hubo un error");
            }
        }
        return nombre;
        }
    
    
}
