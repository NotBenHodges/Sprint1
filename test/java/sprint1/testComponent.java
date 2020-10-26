package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testComponent
{
	Card c;
	Card k;
	
	Description d;
	Checklist check;
	Attachment a;

	@BeforeEach
	void setUp() throws Exception
	{
		c = new Card("Monster");
		k = new Card("Spell");
		d = new Description("This is a monster");
		check = new Checklist();
		a = new Attachment();
	}

	@Test
	void test()
	{
		check.addItem("Play the card");
		check.addItem("Activate effect");
		check.addItem("Win the game");
		assertEquals(check.items.size(),3);
		assertEquals(check.items.get(0),"Play the card");
		
		check.removeItem(0);
		assertEquals(check.items.size(),2);
		assertEquals(check.items.get(0),"Activate effect");
		
		d.addComponent(c, 0);
		check.addComponent(c, 1);
		a.addComponent(c, 2);
		assertEquals(c.components.size(),3);
		
		d.addComponent(k, 0);
		check.addComponent(k, 1);
		a.addComponent(k, 2);
		assertEquals(c.components.size(),3);
		d.removeComponent(k, 0);
		check.removeComponent(k, 0);
		a.removeComponent(k, 0);
		assertEquals(k.components.size(),0);
		
		Description testDesc = d.getComponent(c, 0);
		assertEquals(testDesc.description,"This is a monster");
		
		d.removeComponent(c, 0);
		assertEquals(c.components.size(),2);
		assertEquals(c.components.get(0),check);
		
		Checklist testCheck = check.getComponent(c, 0);
		assertEquals(testCheck.items.size(),2);
		assertEquals(testCheck.items.get(0),"Activate effect");
		
		d.writeToDisk();
		Description diskD = Description.loadFromDisk();
		assertEquals(diskD.description,"This is a monster");
		
		check.writeToDisk();
		Checklist diskCheck = Checklist.loadFromDisk();
		assertEquals(diskCheck.items.size(),2);
		assertEquals(diskCheck.items.get(0),"Activate effect");
		
		a.writeToDisk();
		Attachment diskA = Attachment.loadFromDisk();
		assertEquals(diskA.file,null);
	}

}
