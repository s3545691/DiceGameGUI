package view;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import controller.PlaceBetController;
import controller.RollHouseController;
import controller.RollPlayerController;
import controller.WindowController;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MainFrame extends JFrame
{
	public JButton buttonOne;
    public JButton buttonTwo;
    public JButton buttonThree;
    private JMenu jMenu;
    public JLabel diceOneLabel;
    public JLabel diceTwoLabel;
    public JLabel menuLabel;
    public JMenuItem addLabel;
    private JMenuBar menuBarLabel;
    private JScrollPane scrollPanelOne;
    private JScrollPane scrollPanelTwo;
    public JTextArea textArea;
    public JTextField BetField;
    public JTable table;
	
	
	public GameEngine gameEngine;
    AddPlayer addPlayer;

    public GameEngineCallbackGUI GameEngineCallbackGUI;
    PlaceBetController placeBetController;
    RollPlayerController rollPlayerController;
    RollHouseController rollHouseController;
    WindowController WindowController;
    public boolean GUIrolling = false; 
    public String currentPlayer;

	public MainFrame(GameEngine gameEngine) 
	{
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.ORANGE);
		initComponents();
		this.gameEngine = gameEngine;

		addPlayer = new AddPlayer(gameEngine);

		addPlayer = new AddPlayer(gameEngine);
        placeBetController = new PlaceBetController(gameEngine, this);
        rollPlayerController = new RollPlayerController(gameEngine, this);
        rollHouseController = new RollHouseController(gameEngine, this);
        WindowController = new WindowController(this);
        this.diceOneLabel.setIcon(new ImageIcon("df1.png"));
        this.diceTwoLabel.setIcon(new ImageIcon("df1.png"));
        getContentPane().setLayout(null);
        getContentPane().add(BetField);
        getContentPane().add(buttonOne);
        getContentPane().add(scrollPanelOne);
        getContentPane().add(diceOneLabel);
        getContentPane().add(diceTwoLabel);
        getContentPane().add(buttonThree);
        getContentPane().add(buttonTwo);
        getContentPane().add(menuLabel);
        getContentPane().add(scrollPanelTwo);
        		textArea = new javax.swing.JTextArea();
        		textArea.setBackground(Color.WHITE);
        		textArea.setBounds(422, 17, 272, 178);
        		getContentPane().add(textArea);
        		
        		
        				textArea.setColumns(20);
        				textArea.setRows(5);
        this.setVisible(true);

	}

	private void initComponents() 
	{

		scrollPanelOne = new javax.swing.JScrollPane();
		scrollPanelOne.setBounds(10, 17, 377, 222);
		table = new javax.swing.JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		diceOneLabel = new javax.swing.JLabel();
		diceOneLabel.setBounds(422, 208, 89, 90);
		diceTwoLabel = new javax.swing.JLabel();
		diceTwoLabel.setBounds(544, 208, 90, 90);
		buttonThree = new javax.swing.JButton();
		buttonThree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		buttonThree.setBounds(10, 309, 222, 23);
		buttonTwo = new javax.swing.JButton();
		buttonTwo.setBounds(10, 350, 222, 29);
		menuLabel = new javax.swing.JLabel();
		menuLabel.setBounds(274, 331, 420, 30);
		BetField = new javax.swing.JTextField();
		BetField.setBackground(Color.ORANGE);
		BetField.setBounds(140, 264, 120, 33);
		buttonOne = new javax.swing.JButton();
		buttonOne.setBounds(10, 265, 120, 30);
		scrollPanelTwo = new javax.swing.JScrollPane();
		scrollPanelTwo.setBounds(422, 17, 272, 170);
		menuBarLabel = new javax.swing.JMenuBar();
		jMenu = new javax.swing.JMenu();
		addLabel = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(51, 102, 255));
		setMinimumSize(new java.awt.Dimension(720, 450));
		setPreferredSize(new java.awt.Dimension(720, 450));

		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"ID", "Name", "Points", "Bets", "Result"
				}
				));

		scrollPanelOne.setViewportView(table);

		diceOneLabel.setBackground(new java.awt.Color(255, 153, 153));

		buttonThree.setText("Roll Player");


		buttonTwo.setText("Roll House");
		buttonTwo.setPreferredSize(new java.awt.Dimension(109, 29));


		menuLabel.setBackground(new java.awt.Color(255, 255, 255));
		menuLabel.setForeground(Color.ORANGE);

		buttonOne.setText("Place Bet");

		jMenu.setText("DropDownBox");

		addLabel.setText("Add Player");

		addLabel.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMIAddActionPerformed(evt);
			}
		});
		
		jMenu.add(addLabel);

		menuBarLabel.add(jMenu);


		setJMenuBar(menuBarLabel);

		pack();
	}
	    
	private void jMIAddActionPerformed(java.awt.event.ActionEvent evt) 
	{
		addPlayer.setVisible(true);
		addPlayer.setBounds(1, 1, 350, 150);
	}
	
	public void doRefDices(DicePair r)
    {
        
            if(r.getDice1()==1)
            {
                this.diceOneLabel.setIcon(new ImageIcon("faceOne.png"));
            }
            if(r.getDice1()==2)
            {
                this.diceOneLabel.setIcon(new ImageIcon("faceTwo.png"));
            }
            if(r.getDice1()==3)
            {
                this.diceOneLabel.setIcon(new ImageIcon("faceThree.png"));
            }
            if(r.getDice1()==4)
            {
                this.diceOneLabel.setIcon(new ImageIcon("faceFour.png"));
            }
            if(r.getDice1()==5)
            {
                this.diceOneLabel.setIcon(new ImageIcon("faceFive.png"));
            }
            if(r.getDice1()==6)
            {
                this.diceOneLabel.setIcon(new ImageIcon("faceSix.png"));
            }
            
    
        
        
        if(r.getDice2()==1)
        {
            this.diceTwoLabel.setIcon(new ImageIcon("faceOne.png"));
        }
        if(r.getDice2()==2)
        {
            this.diceTwoLabel.setIcon(new ImageIcon("faceTwo.png"));
        }
        if(r.getDice2()==3)
        {
            this.diceTwoLabel.setIcon(new ImageIcon("faceThree.png"));
        }
        if(r.getDice2()==4)
        {
            this.diceTwoLabel.setIcon(new ImageIcon("faceFour.png"));
        }
        if(r.getDice2()==5)
        {
            this.diceTwoLabel.setIcon(new ImageIcon("faceFive.png"));
        }
        if(r.getDice2()==6)
        {
            this.diceTwoLabel.setIcon(new ImageIcon("faceSix.png"));
        }
    }

    public void doRefName(String name,DicePair dicePair)
    {
        this.menuLabel.setText(name + "First dice is: " + dicePair.getDice1()+ ",Second dice is: " + dicePair.getDice2()+ " Final result: " + (dicePair.getDice1()+dicePair.getDice2()));
    }
    
	public void table() 
	{
	     DefaultTableModel dtm = new DefaultTableModel();
	        
	        String[] tableHeads = new String[]{"ID", "Name", "Points","Bets","Result"};
	        
	        dtm.setColumnIdentifiers(tableHeads);
	        
	        List<Player> data = (List)gameEngine.getAllPlayers();
	        
	        for(int i = 0; i < data.size();i++)
	        {
	            Player player = data.get(i);
	            {
	                
	                Object[] dataRow =
	                {player.getPlayerId(), player.getPlayerName(), player.getPoints(),player.getBet(),
	                    player.getRollResult() == null? "" : player.getRollResult().getDice1()
	                        + player.getRollResult().getDice2()};
	                
	                dtm.addRow(dataRow);
	            }
	        }
	        
	        this.table.setModel(dtm);
	}
	
    public void doRefTextArea(DicePair dicePair,GameEngine gameEngine)
    {
        String houseInfo = "";
        
        houseInfo = "HOUSE:" + " *RESULT* Dice 1: " + dicePair.getDice1() +
                "  Dice 2: " + dicePair.getDice2()  + " ..Total: " + (dicePair.getDice1()+dicePair.getDice2())+"\n";
        
      
        
        for(Player player:gameEngine.getAllPlayers())
        {
            houseInfo += player.toString()+"\n";
        }
        
        this.textArea.setText(houseInfo);
    }
}
