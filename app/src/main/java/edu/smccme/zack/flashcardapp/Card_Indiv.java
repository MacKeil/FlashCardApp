package edu.smccme.zack.flashcardapp;

/**
 * Created by zack on 2/1/16.
 */
public class Card_Indiv {
    private boolean m_isCorrect;
    private int m_whichIsRight;
    private int m_cardID;
    private String m_question;
    private int m_CollectionID;

    public void Card_Indiv(String question, int whichIsRight, int CardID, int CollectionID){
        m_isCorrect = false;
        this.m_question = question;
        this.m_whichIsRight = whichIsRight;
        this.m_cardID = CardID;
        this.m_CollectionID = CollectionID;

    }
    //make a bare minimum constructor.
    public void Card_Indiv(String question, int whichIsRight, int CollectionID){
        m_isCorrect = false;
        this.m_question = question;
        this.m_whichIsRight = whichIsRight;
        this.m_CollectionID = CollectionID;
    }

    //Start the getter functions
    public boolean getCorrect(){
        return m_isCorrect;
    }

    public int getCardID(){
        return m_cardID;
    }

    public int getWhichIsRight(){
        return m_whichIsRight % 2;//there's only two options so we need to make this int binary
    }

    //what was the question again?
    public String getQuestion(){
        return m_question;
    }

    public int getCollectionID(){
        return m_CollectionID;
    }

    //now we implement a method to make the right answer
    public boolean clickedOne(int WhichOne){
        int converter = WhichOne % 2; // convert to binary because we only have two choices
        if(converter == (m_whichIsRight % 2)){//check if it's the right answer
            m_isCorrect = true;//if it is right switch the state of our boolean
        }
        return m_isCorrect;//no matter what we need to tell the program how the user did
    }
}
