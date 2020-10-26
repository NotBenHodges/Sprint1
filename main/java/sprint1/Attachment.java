package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Attachment implements Component
{
	File file;

	public Attachment(File file)
	{
		this.file = file;
	}
	
	public Attachment()
	{
		
	}

	/**
	 * @return the file
	 */
	public File getFile()
	{
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file)
	{
		this.file = file;
	}

	public void addComponent(Card card, int index)
	{
		card.components.add(this);
		
	}

	public void removeComponent(Card card, int index)
	{
		card.components.remove(index);
		
	}

	public Component getComponent(Card card, int index)
	{
		return card.components.get(index);
		
	}
	
	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Attachment.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File Attachment.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static Attachment loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Attachment.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File Attachment.xml not found");
			}
			Attachment A = (Attachment) decoder.readObject();
			return A;
	}

}
