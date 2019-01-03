package view;

import controller.ClearController;
import controller.AddPlayerController;
import javax.swing.JOptionPane;
import model.interfaces.GameEngine;
import javax.swing.JLabel;
import java.awt.Label;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPlayer extends javax.swing.JFrame 
{
    GameEngine gameEngine;
    GameEngineCallbackGUI callBackGUI;
    AddPlayerController addPlayerControl;
    ClearController clearController;
    

    public AddPlayer() 
    {
        initComponents();
    }
    
    public AddPlayer(GameEngine gameEngine)
    {
        initComponents();
        this.gameEngine=gameEngine;
        addPlayerControl = new AddPlayerController(gameEngine, this);
        clearController = new ClearController(this);
    }


    private void initComponents() 
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        pack();
        getContentPane().setLayout(new MigLayout("", "[92px][146px][57px]", "[39px][37px][23px]"));
                getContentPane().setLayout(new GridLayout(0, 5, 0, 0));
        
                name = new javax.swing.JLabel();
                
                        name.setText("Name: ");
                        getContentPane().add(name);
        nameText = new javax.swing.JTextField();
        getContentPane().add(nameText);
        
        label = new JLabel("");
        getContentPane().add(label);
        jBAdd = new javax.swing.JButton();
        
                jBAdd.setText("Add");
                getContentPane().add(jBAdd);
        
        label_2 = new JLabel("");
        getContentPane().add(label_2);
        x = new javax.swing.JLabel();
        
                x.setText("Initial Points: ");
                getContentPane().add(x);
        xText = new javax.swing.JTextField();
        getContentPane().add(xText);
        
        label_3 = new JLabel("");
        getContentPane().add(label_3);
        jBClear = new javax.swing.JButton();
        jBClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        
                jBClear.setText("Clear");
                getContentPane().add(jBClear);
        
        label_4 = new JLabel("");
        getContentPane().add(label_4);
        
        label_5 = new JLabel("");
        getContentPane().add(label_5);
    }

 
    public javax.swing.JButton jBAdd;
    public javax.swing.JButton jBClear;
    private javax.swing.JLabel x;
    private javax.swing.JLabel name;
    public javax.swing.JTextField xText;
    public javax.swing.JTextField nameText;

    private final JLabel label_1 = new JLabel("New label");
    private JLabel label;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
}
