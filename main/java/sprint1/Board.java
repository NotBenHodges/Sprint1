package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Board
{
	User owner;
	String boardName;
	ArrayList <User> members = new ArrayList<User>();
	ArrayList <List> lists = new ArrayList<List>();

	public Board(User owner, String boardName)
	{
		this.owner = owner;
		this.boardName = boardName;
	}
	
	public Board()
	{
		this.boardName = "New Board";
		User newUser = new User("username","password");
		this.owner = newUser;
	}
	
	public void addMember(User member, User owner)
	{
		if(this.owner == owner)
		{
			members.add(member);
		}
	}
	
	public void createList(String listName)
	{
		List newList = new List(listName);
		lists.add(newList);
	}
	
	public void removeList(int index)
	{
		lists.remove(index);
	}
	
	public void moveList(int newIndex, int oldIndex)
	{
		List temp = lists.get(oldIndex);
		lists.remove(oldIndex);
		lists.add(newIndex, temp);
	}
	
	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Board.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File Board.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static Board loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Board.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File Board.xml not found");
			}
			Board B = (Board) decoder.readObject();
			return B;
	}

	/**
	 * @return the owner
	 */
	public User getOwner()
	{
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner)
	{
		this.owner = owner;
	}

	/**
	 * @return the boardName
	 */
	public String getBoardName()
	{
		return boardName;
	}

	/**
	 * @param boardName the boardName to set
	 */
	public void setBoardName(String boardName)
	{
		this.boardName = boardName;
	}

	/**
	 * @return the members
	 */
	public ArrayList<User> getMembers()
	{
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList<User> members)
	{
		this.members = members;
	}

	/**
	 * @return the lists
	 */
	public ArrayList<List> getLists()
	{
		return lists;
	}

	/**
	 * @param lists the lists to set
	 */
	public void setLists(ArrayList<List> lists)
	{
		this.lists = lists;
	}


}
