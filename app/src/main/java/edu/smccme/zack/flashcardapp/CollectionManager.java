package edu.smccme.zack.flashcardapp;

import java.util.LinkedList;

/**
 * Created by zack on 2/22/16.
 * This is class to act as a control to the control of the cards
 */
public class CollectionManager {
    private LinkedList<CardManager> m_cms;//using a linked list for extensibility purposes.

    //basic constructor function
    public CollectionManager(){
        m_cms = new LinkedList<>();
    }

    //input
    public void add(CardManager cm){
        m_cms.add(cm);//LinkedList doing all my work for me.
    }

    public void addLocation(int indexPoint, CardManager cm){
        m_cms.add(indexPoint, cm);
    }

    //processing
    public void remove(int index){
        m_cms.remove();
    }

    public void remove(Object o){
        m_cms.remove();
    }

    //output
    public CardManager getCMAtIndex(int index){
        return m_cms.get(index);
    }

}
