package edu.smccme.zack.flashcardapp;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by zack on 1/31/16.
 */
public class Card_Collection {
    //Declare member variables
    private int m_CollectionID;// these ID's are so I can drop this code into SQLight if I want
    private Card_Indiv[] m_cards;
    private ArrayList<Card_Indiv> m_container;//so the collection can expand.
    private int m_numberOfCards;
    private String m_CollectionName;
    private int[] m_gotCorrectIndexs;

    public void Card_Collection(int id, Card_Indiv[] cs, String name){
        this.m_CollectionID = id;
        this.m_cards = cs;
        this.m_container = new ArrayList<>(Arrays.asList(cs));
        this.m_CollectionName = name;
        this.m_numberOfCards = cs.length;
        this.m_gotCorrectIndexs = new int[cs.length];
    }

    public void Card_Collection(int length, String name){
        this.m_numberOfCards = length;
        this.m_cards = new Card_Indiv[length];
        this.m_CollectionName = name;
        this.m_gotCorrectIndexs = new int[length];
    }

    // Start the getter functions
    public int getCollectionID(){
        return m_CollectionID;
    }

    public Card_Indiv getCard(int index){
        return m_cards[index];
    }

    public Card_Indiv[] getAllCards(){
        return m_cards;
    }

    public int getSizeOfCollection(){
        return m_numberOfCards;
    }

    public String getCollectionName(){
        return m_CollectionName;
    }

    public int[] getRightAnswers(){
        return m_gotCorrectIndexs;
    }

    // Need an add function
    public void add(Card_Indiv newCard){
        m_container.add(newCard);
        copyContainer(m_container.size());
    }

    //recusive copy function
    private void copyContainer(int index){
        //check if the array will even hold the values
        if(index <= m_cards.length && m_container.size() == m_cards.length) {
            if (index > 0) {//check if the index is more than zero
                m_cards[index] = m_container.get(index);//copy the value over
                copyContainer(index - 1);//call the function again at one lower
            } else if (index == 0) {//if the index is 0 just copy that and be done
                m_cards[index] = m_container.get(index);
            }
        }
        else if(index > m_container.size()){
            throw(new IllegalArgumentException());
        }
        //if the array is too small, or too big scrap it and call the function again with a bigger one.
        else {
            m_cards = new Card_Indiv[m_container.size()];
            copyContainer(index);
        }

    }
    // Need a remove function
    public void remove(int index){
        //simply remove the item from the container and then copy the array
        m_container.remove(index);
        copyContainer(m_container.size());
    }


}
