package controller;

import view.MainFrame;

public class WindowController 
{
	public WindowController(MainFrame mainFrame) 
	{
        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowActivated(java.awt.event.WindowEvent evt) 
            {
                mainFrame.table();
            }
        });
	}
}
