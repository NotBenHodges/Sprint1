package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testList
{
	List l;
	List s;
	
	Card d;
	Card v;
	Card p;

	@BeforeEach
	void setUp() throws Exception
	{
		l = new List("todo");
		s = new List("shopping");
		
		d = new Card("dust");
		v = new Card("vaccum");
		p = new Card("peppers");
	}

	@Test
	void test()
	{
		l.createCard(d);
		l.createCard(v);
		s.createCard(p);
		
		assertEquals(l.cards.get(0),d);
		assertEquals(l.cards.get(1),v);
		
		l.moveCard(0, "vaccum");
		assertEquals(l.cards.get(0).cardName,"vaccum");
		
		l.swapCard(s, 1, 1);
		assertEquals(s.cards.get(1).cardName,"dust");
		
		s.removeCard(1);
		assertEquals(s.cards.size(),1);
		
		l.createCard(d);
		
		l.writeToDisk();
		List diskl = List.loadFromDisk();
		assertEquals(diskl.listName, "todo");
		assertEquals(diskl.cards.size(),2);
		assertEquals(diskl.cards.get(0).cardName,"vaccum");
	}

}
