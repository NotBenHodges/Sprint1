package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testCard
{
	Card c;
	Card k;
	
	User Bob;
	User Wade;
	User Mark;
	
	Description d;
	
	@BeforeEach
	void setUp() throws Exception
	{
		c = new Card("Monster");
		k = new Card("Spell");
		d = new Description("This is a monster");
		
		Bob = new User("Bobby","1234");
		Wade = new User("Slade","4321");
		Mark = new User("Mark","0000");
	}

	@Test
	void test()
	{
		c.addMember(Mark);
		c.addMember(Bob);
		c.addMember(Wade);
		assertEquals(c.cardMembers.size(),3);
		
		c.removeMember(2);
		assertEquals(c.cardMembers.size(),2);
		
		ArrayList<User> testMembers = c.getMembers();
		assertEquals(testMembers.size(),2);
		
		c.addLabel("Level 3");
		c.addLabel("Dark Type");
		ArrayList<String> testLabels = c.getLabels();
		assertEquals(testLabels.size(),2);
		assertEquals(testLabels.get(0),"Level 3");
		
		c.removeLabel(0);
		assertEquals(c.labels.size(),1);
		
		c.writeToDisk();
		Card diskC = Card.loadFromDisk();
		assertEquals(diskC.cardName,"Monster");
		assertEquals(diskC.cardMembers.size(),2);
		assertEquals(diskC.labels.size(),1);
	}

}
