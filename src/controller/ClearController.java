package controller;

import view.AddPlayer;

public class ClearController 
{
	AddPlayer playerToBeAdded = new AddPlayer();
	
	public ClearController(AddPlayer playerToBeAdded) 
	{
		playerToBeAdded.jBClear.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
	            	playerToBeAdded.nameText.setText("");
	            	playerToBeAdded.xText.setText("");
            }
        });
	}
}
