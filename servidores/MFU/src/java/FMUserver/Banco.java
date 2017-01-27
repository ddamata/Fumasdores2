/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMUserver;

/**
 *
 * @author Daniel
 */
public class Banco {
    
    boolean hayIngredientes;
    String banco;
    clienteTraza Traza = new clienteTraza();

    Banco( String Banco ,boolean ingrediente ){
		hayIngredientes = ingrediente;
                banco = Banco;
	}
	
	public synchronized String nuevosIngredientes () throws  InterruptedException {
		//Se comprueba que si el banco ya tiene ingredientes.
		if (!hayIngredientes){
			//Se agrega fosforos al banco.
			hayIngredientes = Boolean.TRUE;
			//imprimo por pantalla la accion 
			System.out.println("Vendedor - Agrego ingrediente "+banco);
			Traza.escribirTraza(hora.horaActual(), "Vendedor", "Agrego ingrediente "+banco);
                        Thread.sleep(10000);
                        return banco+"-Agrego Ingrediente-Vendedor-"+hora.horaActual()+"-"+Boolean.TRUE;
		}else
                {
                    return banco+"-Agrego Ingrediente-Vendedor-"+hora.horaActual()+"-"+Boolean.FALSE;
                }
	} 

	public synchronized String RecogerIngredientes (int id) throws  InterruptedException {
		//Se comprueba que si el banco ya tiene ingredientes.
		if (! hayIngredientes )
                {
                    
                    return banco+"-Recoge Ingrediente-Fumador "+id+"-"+hora.horaActual()+"-"+Boolean.FALSE;
                          
		}
                else 
                {
                    hayIngredientes =Boolean.FALSE;
                    if(id==0)
                    {
				
                        System.out.println("Fumador(Tabaco) - Agarro ingrediente del "+banco);
                        Traza.escribirTraza(hora.horaActual(), "Fumador(Tabaco)" , "Agarro ingrediente del "+banco);
                        Thread.sleep(10000);
                        return banco+"-Recoge Ingrediente-Fumador (Tabaco) "+id+"-"+hora.horaActual()+"-"+Boolean.TRUE;
                        
                        //Se registra el evento en la traza de tipo XML.
                       
                    }
                    else
                    {              
                            if(id==1)
                            {
                                System.out.println("Fumador(Papel) - Agarro ingrediente del "+banco);
                                Traza.escribirTraza(hora.horaActual(), "Fumador(Papel)" , "Agarro ingrediente del "+banco);
                                return  banco+"-Recoge Ingrediente-Fumador (Papel) "+id+"-"+hora.horaActual()+"-"+Boolean.TRUE;
                                //Se registra el evento en la traza de tipo XML.
				//Traza.insertarTraza(Hora.horaActual(), "Fumador(Papel)", "Agarro fosforo del banco.");
                            }
                            else
                            {
                                if (id == 2)
                                {
                                    System.out.println("Fumador(Fosforo) -  Agarro ingrediente del "+banco);
                                    Traza.escribirTraza(hora.horaActual(), "Fumador(Fosforo)" , "Agarro ingrediente del "+banco);
                                    return  banco+"-Recoge Ingrediente-Fumador (Fosforo) "+id+"-"+hora.horaActual()+"-"+Boolean.TRUE;
                                    //Se registra el evento en la traza de tipo XML.
                                    //Traza.insertarTraza(Hora.horaActual(), "Fumador(Fosforo)", "Agarro fosforo del banco");
                                }
                            }
                    }
                }
            return  "Recoge Ingrediente Error-Fumador "+id+"-"+hora.horaActual()+"-"+Boolean.FALSE;
        }	
                  
    
}
