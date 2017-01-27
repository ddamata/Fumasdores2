package com.mfu.client;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interfacermi.itraza;

public class clienteTraza {

    final public static int BUF_SIZE = 1024 * 64;

	public String descargarTraza(){
        try {
            // System.setSecurityManager(new RMISecurityManager());
            Registry registry = LocateRegistry.getRegistry("192.168.0.3",1099);
            itraza server;
            server = (itraza) registry.lookup("itraza");
            byte[] filedata = server.downloadFile("Traza.xml");
            File file = new File("Traza.xml");
            BufferedOutputStream output = new
            BufferedOutputStream(new FileOutputStream(file.getName()));
            output.write(filedata,0,filedata.length);
            output.flush();
            output.close();
            return "Descarga de traza Exitosa.";
        } catch (Exception e) {
        	
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
            return "ERROR en la descarga.";
        }
    }
	
	public String subirTraza () {
		try {
			Registry registry = LocateRegistry.getRegistry("192.168.0.3",1099);
			itraza server;
			 server = (itraza) registry.lookup("itraza");
			 if (server.deleteFile()){
			 server.sendFileName("Traza.xml");
			 FileInputStream fin = new FileInputStream("Traza.xml");
			 byte[] data = new byte[8192]; int byteReads;
			 byteReads = fin.read(data);
			 while(byteReads != -1) { 
				 server.sendData(data, 0, byteReads); 
				 byteReads = fin.read(data); 
			} 
			server.close();
			
			}
			 return "Traza Restaurada con exito";
		} catch (Exception e) {
			return "error al  restaurar Traza";
			// TODO Auto-generated catch block
			
		}
	}
	
}
