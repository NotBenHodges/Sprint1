package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Checklist implements Component
{
	ArrayList<String> items = new ArrayList<String>();
	
	public Checklist()
	{
		
	}

	public void addComponent(Card card, int index)
	{
		card.components.add(this);
		
	}

	public void removeComponent(Card card, int index)
	{
		card.components.remove(index);
		
	}

	public Checklist getComponent(Card card, int index)
	{
		if(card.components.get(index) instanceof Checklist)
		{
			return (Checklist)card.components.get(index);
		}
		else
		{
			return null;
		}
		
	}
	
	public void addItem(String item)
	{
		items.add(item);
	}
	
	public void removeItem(int index)
	{
		items.remove(index);
	}
	
	public String getItem(int index)
	{
		if(items.size() == 0)
		{
			return null;
		}
		else
		{
			return items.get(index);
		}
	}
	
	/**
	 * @return the items
	 */
	public ArrayList<String> getItems()
	{
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<String> items)
	{
		this.items = items;
	}

	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Checklist.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static Checklist loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Checklist.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File Checklist.xml not found");
			}
			Checklist C = (Checklist) decoder.readObject();
			return C;
	}
}
