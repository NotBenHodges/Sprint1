package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Description implements Component
{
	String description;

	public Description(String description)
	{
		this.description = description;
	}
	
	public Description()
	{
		this.description = "This is a description";
	}

	public void addComponent(Card card, int index)
	{
		card.components.add(this);
		
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	public void removeComponent(Card card, int index)
	{
		card.components.remove(index);
		
	}

	public Description getComponent(Card card, int index)
	{
		if(card.components.get(index) instanceof Description)
		{
			return (Description)card.components.get(index);
		}
		else
		{
			return null;
		}
		
	}
	
	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Description.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static Description loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Description.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File Card.xml not found");
			}
			Description D = (Description) decoder.readObject();
			return D;
	}

}
