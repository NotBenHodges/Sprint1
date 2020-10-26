package sprint1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class User
{
	String username;
	String password;
	ArrayList<Board> boardsOwned = new ArrayList<Board>();
	ArrayList<Board> boardsMember = new ArrayList<Board>();

	public User(String username, String password)
	{
		this.username=username;
		this.password=password;
	}
	
	public User()
	{
		this.username = "Thomas";
		this.password = "Anderson";
	}
	
	public boolean login(String username, String password)
	{
		if(this.username == username && this.password == password)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void createOwnedBoard(Board newBoard)
	{
		//Board newBoard = new Board(owner, boardName);
		boardsOwned.add(newBoard);
	}

	/*
	public static void main(String[] args)
	{

	}
	*/
	public void writeToDisk()
	{
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("User.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static User loadFromDisk()
	{
			XMLDecoder decoder=null;
			try {
				decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("User.xml")));
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File dvd.xml not found");
			}
			User U = (User) decoder.readObject();
			return U;
	}
		
		
	public boolean equals(User that)
	{
		if(boardsOwned.size() != that.boardsOwned.size()) {return false;}
		/*
		for(Board b:boardsOwned)
		{
			if(!that.contains(b)) {return false;}
		}*/
		
		if(that.username != this.username || that.password != this.password) {return false;}
		return true;
	}
	/*
	public boolean contains(Board board)
	{
		for(board:boardsOwned)
		{
			if()
		}
	}*/
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the boardsOwned
	 */
	public ArrayList<Board> getBoardsOwned()
	{
		return boardsOwned;
	}

	/**
	 * @param boardsOwned the boardsOwned to set
	 */
	public void setBoardsOwned(ArrayList<Board> boardsOwned)
	{
		this.boardsOwned = boardsOwned;
	}

	/**
	 * @return the boardsMember
	 */
	public ArrayList<Board> getBoardsMember()
	{
		return boardsMember;
	}

	/**
	 * @param boardsMember the boardsMember to set
	 */
	public void setBoardsMember(ArrayList<Board> boardsMember)
	{
		this.boardsMember = boardsMember;
	}

}
