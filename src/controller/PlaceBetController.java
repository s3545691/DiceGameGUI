package controller;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;
import view.MainFrame;

public class PlaceBetController 
{
	public PlaceBetController(GameEngine gameEngine, MainFrame mainFrame) 
	{
		 mainFrame.buttonOne.addActionListener(new java.awt.event.ActionListener() 
		 {
	            public void actionPerformed(java.awt.event.ActionEvent evt) 
	            {
	            	 String message = "";

	                 
	                 String id = (mainFrame.table.getValueAt(mainFrame.table.getSelectedRow(), 0).toString());
	                 
	                 if(isInteger(mainFrame.BetField.getText()))
	                 {
	                	 	int bet = Integer.parseInt(mainFrame.BetField.getText());
	                	 	gameEngine.getPlayer(id).placeBet(bet);
	                 }
	                 else 
	                 {
                	 	 	message = "Please enter an interger !";
	                	 	
	                	 	JOptionPane.showMessageDialog(null, message ,"Message", JOptionPane.ERROR_MESSAGE);
	                 }
	                 mainFrame.table();
	            }
	        });
	}
	

	public static boolean isInteger(String str)
	{
		Pattern pattern = Pattern.compile("^-?[0-9]+");

		if(pattern.matcher(str).matches())
		{  
			return true;
		} 
		else 
		{
			return false;
		}  
	}
}