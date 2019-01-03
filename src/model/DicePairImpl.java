package model;

import model.interfaces.*;

public class DicePairImpl implements DicePair
{
    private int dice1, dice2;
    private final int NUM_FACES;
    
    public DicePairImpl(int dice1, int dice2, int NUM_FACES)
    {
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.NUM_FACES = NUM_FACES;
    }
    
    @Override
    public int getDice1()
    {
        return dice1;
    }
    
    @Override
    public int getDice2()
    {
        return dice2;
    }
    
    @Override
    public int getNumFaces()
    {
        return NUM_FACES;
    }

    public void setDice1(int dice1) 
    {
        this.dice1 = dice1;
    }

    public void setDice2(int dice2) 
    {
        this.dice2 = dice2;
    }
    
}
