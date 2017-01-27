package FMUserver;

import interfacermi.itraza;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class clienteTraza {
    
    public void escribirTraza(String hora, String  actor, String  accion){
        try {
            // System.setSecurityManager(new RMISecurityManager());
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
            itraza server;
            server = (itraza) registry.lookup("itraza");
            server.insertarTraza (hora, actor, accion);
            System.out.println("response: ejecute " );
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
    
    
}
