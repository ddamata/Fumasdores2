package interfacermi;
import java.io.IOException;
import java.rmi.*;  
public interface itraza extends Remote {  
    
    public  void insertarTraza (String hora,String actor, String accion)throws RemoteException;  
    public byte[] downloadFile (String fileName)  throws RemoteException;  
     public void close() throws RemoteException; 
     public void sendData(byte[] data, int offset, int length) throws RemoteException; 
     public void sendFileName(String fileName) throws RemoteException;
     public boolean deleteFile () throws RemoteException;
     
}  