package com.mfu.client;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class vista extends JFrame {
	private Random randomN = new Random();
	private JPanel contentPane;
	boolean ejecutar = Boolean.FALSE;


	public vista() {
		Boolean ingredientes[] = {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE } ;
		String[] ids = {"Fumador", "Vendedor"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 17, 14);
		contentPane.add(lblId);
		
		JComboBox comboBox = new JComboBox(ids);
		comboBox.setBounds(37, 8, 145, 20);
		contentPane.add(comboBox);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setColumns(30);
		textArea.setBounds(10, 47, 414, 166);
		textArea.setLineWrap(true);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 47, 414, 166);
		contentPane.add(scrollPane);
		
		
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				respuesta r;
				ejecutar = Boolean.TRUE;
		
				switch (comboBox.getSelectedIndex()){

				case 0:
					if ( ingredientes[0] &&  ingredientes[1] && ingredientes[2]){
						 
						 ingredientes[0] =Boolean.FALSE;
						 ingredientes[1]= Boolean.FALSE;
						 ingredientes[2]= Boolean.FALSE;
						 textArea.append("fumando");
						 textArea.append("\n\r");
						 try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}	else {
					
					if (! ingredientes[0]){
							r = conexion.conectar("http://192.168.0.3:8080/MFU/webresources/restServicesMFU/recogerPapel/"+comboBox.getSelectedIndex());
							if (r.getRespuesta()){
	
								ingredientes[0] = r.getRespuesta();
								textArea.append(r.getBanco()+""+r.getAccion()+" "+r.getActor()+" "+r.getHora());
								textArea.append("\n\r");
							}
							
						}
						if (! ingredientes[1]){
							r = conexion.conectar("http://192.168.0.3:8080/MFU/webresources/restServicesMFU/recogerFosforo/"+comboBox.getSelectedIndex());
							if (r.getRespuesta()){
	
								ingredientes[1] = r.getRespuesta();
								textArea.append(r.getBanco()+""+r.getAccion()+" "+r.getActor()+" "+r.getHora());
								textArea.append("\n\r");
								
							}
							if (! ingredientes[2]){
								r = conexion.conectar("http://192.168.0.3:8080/MFU/webresources/restServicesMFU/recogerTabaco/"+comboBox.getSelectedIndex());
								if (r.getRespuesta()){
		
									ingredientes[2] = r.getRespuesta();
									textArea.append(r.getBanco()+""+r.getAccion()+" "+r.getActor()+" "+r.getHora());
									textArea.append("\n\r");
									
								}
							}
						}
					}
					break;
				case 1:
											
						
						int control = randomN.nextInt(3);
						switch ( control ){
							case 0:
								r = conexion.conectar("http://192.168.0.3:8080/MFU/webresources/restServicesMFU/agregarIngrediente/"+control);
								if (r.getRespuesta()){

									textArea.append(r.getBanco()+""+r.getAccion()+" "+r.getActor()+" "+r.getHora());
									textArea.append("\n\r");
								}
								break;
							case 1:
								r = conexion.conectar("http://192.168.0.3:8080/MFU/webresources/restServicesMFU/agregarIngrediente/"+control);
								if (r.getRespuesta()){

									textArea.append(r.getBanco()+""+r.getAccion()+" "+r.getActor()+" "+r.getHora());
									textArea.append("\n\r");
								}
								break;
							case 2: 
								r = conexion.conectar("http://192.168.0.3:8080/MFU/webresources/restServicesMFU/agregarIngrediente/"+control);
								if (r.getRespuesta()){
									textArea.append(r.getBanco()+""+r.getAccion()+" "+r.getActor()+" "+r.getHora());
									textArea.append("\n\r");
									
								break;
								}
					break;
					
				
						
						
						}
				}
			}
			
		});
		btnConectar.setBounds(335, 228, 89, 23);
		contentPane.add(btnConectar);
		
		JButton btnVerTraza = new JButton("Replicar");
		btnVerTraza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clienteTraza Traza = new clienteTraza();
				textArea.append(Traza.descargarTraza());
				textArea.append("\n\r");
			}
		});
		btnVerTraza.setBounds(10, 228, 89, 23);
		contentPane.add(btnVerTraza);
		
		JButton btnRestaurar = new JButton("Restaurar");
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteTraza Traza = new clienteTraza();
				textArea.append(Traza.subirTraza());
				textArea.append("\n\r");
			}
		});
		btnRestaurar.setBounds(109, 228, 116, 23);
		contentPane.add(btnRestaurar);
		
		JButton btnVer = new JButton("ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteTraza Traza = new clienteTraza();
				Traza.descargarTraza();
				File file = new File("Traza.xml");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnVer.setBounds(235, 228, 89, 23);
		contentPane.add(btnVer);
		

		
	}
}
