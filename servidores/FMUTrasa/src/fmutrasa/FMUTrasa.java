/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmutrasa;
//<editor-fold defaultstate="collapsed" desc="comment">
import interfacermi.Traza;
import interfacermi.itraza;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.rmi.Naming;
//</editor-fold>
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class FMUTrasa extends UnicastRemoteObject  implements itraza{
    
    FMUTrasa() throws RemoteException{
        super();
    }
    
    public static void main(String[] args) {
        
      
        try {
          
            Registry registry =  LocateRegistry.createRegistry(1099);
            registry.rebind("itraza", new FMUTrasa () );
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void insertarTraza(String hora, String actor, String accion) throws RemoteException {
        Traza t = new Traza();
        t.insertarTraza(hora, actor, accion);
                
    }

    @Override
    public byte[] downloadFile(String fileName) throws RemoteException {
        
         File file = new File(fileName);
         if(file.exists()) {
              
	          FileInputStream fis;
	 try {
         byte buffer[] = new byte[(int)file.length()];
         BufferedInputStream input = new
         BufferedInputStream(new FileInputStream(fileName));
         input.read(buffer,0,buffer.length);
         input.close();
         return(buffer);
      } catch(IOException e){
          
         System.out.println("FileImpl: "+e.getMessage());
         e.printStackTrace();
         return(null);
      }
    }
         System.out.println("el archivo NO existe");
         return null;
    }
       
     FileOutputStream fout = null;
     public void close() throws RemoteException { 
         if(fout != null) { 
             try {
                 fout.close(); 
             } catch (IOException e)
             { e.printStackTrace(); } 
         } 
     }
     public void sendData(byte[] data, int offset, int length) throws RemoteException {
         if(fout != null) { 
             try {
                 fout.write(data, offset, length);
                 fout.flush();
             } catch (IOException e){
                 e.printStackTrace(); 
             } 
         } 
     } 
     public void sendFileName(String fileName) throws RemoteException {
         if(fout == null) { 
             try { 
                 fout = new FileOutputStream(fileName);
             } catch (FileNotFoundException e) {
                 
                 Logger.getLogger(FMUTrasa.class.getName()).log(Level.SEVERE, null, e);
             
            } 
     }


     }

    @Override
    public boolean deleteFile() {
        File xmlFile = new File("Traza.xml");
	      //Se comprueba si el archivo XML ya existe o no.
	      if(xmlFile.exists()) {
	          xmlFile.delete();
                  return Boolean.TRUE;
              }else {
                  return Boolean.TRUE;
               }
        
    }
}

  
