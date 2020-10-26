package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class List
{
	String listName;
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public List(String listName)
	{
		this.listName = listName;
	}
	
	public List()
	{
		this.listName = "New list";
	}

	/**
	 * @return the listName
	 */
	public String getListName()
	{
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName)
	{
		this.listName = listName;
	}

	/**
	 * @return the cards
	 */
	public ArrayList<Card> getCards()
	{
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<Card> cards)
	{
		this.cards = cards;
	}

	public void createCard(Card newCard)
	{
		//Card newCard = new Card(cardName);
		cards.add(newCard);
	}
	
	public void removeCard(int index)
	{
		cards.remove(index);
	}
	
	public void moveCard(int newIndex, String cardName)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			String currentName = cards.get(i).cardName;
			if(currentName.equals(cardName))
			{
				Card temp = cards.get(i);
				cards.remove(i);
				cards.add(newIndex, temp);
			}
		}
	}
	
	public void swapCard(List newList, int currentIndex, int newIndex)
	{
		Card temp = cards.get(currentIndex);
		cards.remove(currentIndex);
		newList.cards.add(newIndex, temp);
	}
	
	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("List.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static List loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("List.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File List.xml not found");
			}
			List L = (List) decoder.readObject();
			return L;
	}

}
