package sprint1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testUserBoard
{
	User Bob;
	User Wade;
	User Mark;
	Board B;
	Board C;
	Board E;
	
	@BeforeEach
	void setup() throws Exception
	{
		Bob = new User("Bobby","1234");
		Wade = new User("Slade","4321");
		Mark = new User("Mark","0000");
		B = new Board(Bob,"Bobs board");
		C = new Board(Wade,"Wades board");
		C = new Board(Bob,"Bobs other board");
	}
	
	@Test
	void testUser()
	{
		assertTrue(Bob.login("Bobby", "1234"));
		assertEquals(B.owner,Bob);
		assertEquals(B.boardName,"Bobs board");
		
		B.addMember(Mark, Bob);
		B.addMember(Wade, Bob);
		assertEquals(B.members.get(0),Mark);
		
		B.createList("ToDo");
		B.createList("Grocery");
		assertEquals(B.lists.get(0).listName, "ToDo");
		B.moveList(0, 1);
		assertEquals(B.lists.get(1).listName, "ToDo");
		B.removeList(1);
		assertEquals(B.lists.size(),1);
		
		Bob.createOwnedBoard(B);
		
		B.writeToDisk();
		Bob.writeToDisk();
		
		User diskU = User.loadFromDisk();
		assertEquals(diskU.username,"Bobby");
		assertEquals(diskU.password,"1234");
		
		Board diskB = Board.loadFromDisk();
		assertEquals(diskB.boardName,"Bobs board");
		assertEquals(diskB.owner.username,"Bobby");
		assertEquals(diskB.owner.password,"1234");
		assertEquals(diskB.members.size(),2);
	}
	
}
