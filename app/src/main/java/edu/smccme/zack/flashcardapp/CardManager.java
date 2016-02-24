package edu.smccme.zack.flashcardapp;

/**
 * Created by zack on 2/13/16.
 *
 * Added functions to get individual cards.
 * Added recursive reset function
 * Added a function to iterate through the collection
 */
public class CardManager {
    //create instance variables
    private Card[] m_cards;
    private int m_size;
    private int m_index;

    public CardManager(int size){
        //initialize the array to the size provided
        m_cards = new Card[size];
        //the size of the object needs to be the size provided
        this.m_size = size;
        //we should probably start at the beginning
        this.m_index = 0;
    }
    //getter function for a card of our choosing
    public Card getCardAtIndex(int index){
        //if the index provided isn't within bounds return null
        if(index > m_cards.length || index < 0){
            return null;
        }
        //otherwise we'll set the instance index to the index provided
        m_index = index;
        return m_cards[index];//return card at index provided
    }
    //basic getter for a card that isn't right yet
    public Card getCardNotRight(){
        //create an iterator int
        int index = 0;
        //as long as we are still getting cards that are right add to our iterator
        while(m_cards[index].getIsRight() && index < m_cards.length - 1){
            index++;
        }
        //if we have a card that hasn't been answered correctly return it.
        if(!m_cards[index].getIsRight()){
            m_index = index;//set the instance index equal to our iterator
            return m_cards[index];
        }
        return null;
    }
    //getter function to return the next card that isn't correct.
    public Card getNextNotRight(){
        //Not going to lie I had a hard time with this one.
        //create an iterator for stepping from the beginning.
        int i = 0;
        //call moveToNext() a function that steps through without going over the max length
        moveToNext(m_index);
        //as long as we haven't reached the end, and we haven't gotten a card that's wrong keep going
        while (m_cards[m_index].getIsRight() && i <= m_cards.length - 1) {
            //since we used the iterator as a test for size we have to make it bigger
            i++;
            //use moveToNext() on the instance index
            moveToNext(m_index);
        }
        //if we didn't start out on the first card, and we still don't have a wrong card...
        if(m_index >= m_cards.length && m_cards[m_index].getIsRight()){
            i = 0;//set our iterator to 0 to start over.
            //same while as before but using only our iterator
            while(m_cards[i].getIsRight() && i < m_cards.length -1){
                i++;
            }
            //whatever out iterator is so to will our instance variable be.
            m_index = i;
        }
        //give the people what they want!
        return m_cards[m_index];
    }
    //This is a function to step through the array without ever going past it's outer bound
    private void moveToNext(int index){
        //if our index is larger than our outer bound...
        if(index >= m_cards.length - 1){
            m_index = 0;//set it back to the beginning
        }
        //Make the instance index one bigger no matter what.
        m_index++;
    }
    //add a card to the manager
    public void addCard(Card c){
        int iterator = 0;//create an iterator for our loop
        //as long as we are still within bounds and we are still pulling up cards
        while(m_cards[iterator] != null && iterator < m_cards.length){
            iterator++;//add one to the iterator
        }
        //if our iterator is still smaller that our outer bound...
        if(iterator < m_cards.length){
            //set that index point equal to the argument
            m_cards[iterator] = c;
        }
    }

    // user beware using this function will reset the entire array
    public void reset(){
        for(int i = m_cards.length - 1; i >= 0; i--){
            m_cards[i].resetCard();
        }
    }


    //getter for the size
    public int getSize(){
        return m_size;
    }


}
