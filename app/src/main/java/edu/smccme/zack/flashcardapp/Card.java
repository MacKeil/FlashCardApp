package edu.smccme.zack.flashcardapp;

/**
 * Created by zack on 2/13/16.
 */
public class Card {
    //set our instance variables up
    private int m_img1ResID;//funny thing I remembered all resource id's resolve to int's
    private int m_img2ResID;
    private int m_qestionResID;
    private boolean m_isRight;
    private int m_whichIsRight;

    //create a constructor that holds
    public Card(int ResIDImg1, int ResIDImg2, int ResIDQuestion, int RightAnswer){
        this.m_img1ResID = ResIDImg1;
        this.m_img2ResID = ResIDImg2;
        this.m_qestionResID = ResIDQuestion;
        this.m_whichIsRight = RightAnswer % 2;
        m_isRight = false;//you're wrong until you're right
    }

    //begin the getter functions
    public int getImg1ResID(){
        return m_img1ResID;
    }

    public int getImg2ResID(){
        return m_img2ResID;
    }

    public int getQuestionID(){
        return m_qestionResID;
    }

    public boolean getIsRight(){
        return m_isRight;
    }

    public int getWhichIsRight(){
        return m_whichIsRight;
    }
    //set the boolean control to true
    public void gotRight(){
        m_isRight = true;
    }
    //set the boolean back to false
    public void resetCard(){
        m_isRight = false;
    }
}
