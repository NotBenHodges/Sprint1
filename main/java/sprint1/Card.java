package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Card
{
	String cardName;
	ArrayList<Component> components = new ArrayList<Component>();
	ArrayList<String> labels = new ArrayList<String>();
	ArrayList<User> cardMembers = new ArrayList<User>();

	public Card(String cardName)
	{
		this.cardName = cardName;
	}
	
	public Card()
	{
		this.cardName = "Exodia";
	}
	
	public void addLabel(String label)
	{
		labels.add(label);
	}
	
	public void removeLabel(int index)
	{
		labels.remove(index);
	}
	
	public ArrayList<String> getLabels()
	{
		return labels;
	}
	
	public void addMember(User member)
	{
		cardMembers.add(member);
	}
	
	public void removeMember(int index)
	{
		cardMembers.remove(index);
	}
	
	public ArrayList<User> getMembers()
	{
		return cardMembers;
	}
	
	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Card.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static Card loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Card.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File Card.xml not found");
			}
			Card C = (Card) decoder.readObject();
			return C;
	}

	/**
	 * @return the cardName
	 */
	public String getCardName()
	{
		return cardName;
	}

	/**
	 * @param cardName the cardName to set
	 */
	public void setCardName(String cardName)
	{
		this.cardName = cardName;
	}

	/**
	 * @return the components
	 */
	public ArrayList<Component> getComponents()
	{
		return components;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(ArrayList<Component> components)
	{
		this.components = components;
	}

	/**
	 * @return the cardMembers
	 */
	public ArrayList<User> getCardMembers()
	{
		return cardMembers;
	}

	/**
	 * @param cardMembers the cardMembers to set
	 */
	public void setCardMembers(ArrayList<User> cardMembers)
	{
		this.cardMembers = cardMembers;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(ArrayList<String> labels)
	{
		this.labels = labels;
	}

}
