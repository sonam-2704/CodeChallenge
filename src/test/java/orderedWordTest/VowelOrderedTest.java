package orderedWordTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.CodeChallenge.VowelOrdered;

public class VowelOrderedTest {
	private VowelOrdered vowelOrdered;
	@Before
	public void beforeTest() {
		vowelOrdered = new VowelOrdered();
	}
	@Test
	public void test1() {
		int count = vowelOrdered.testWord("Bbc");
		System.out.println(count);
		Assert.assertEquals(0,count);
		System.out.println(VowelOrdered.vowelStatus);
		Assert.assertEquals(VowelOrdered.vowelStatus,"Not-Ordered");
	}
	
	@Test
	public void test2() {
		int count = vowelOrdered.testWord("Aeue");
		System.out.println(count);
		Assert.assertEquals(4,count);
		System.out.println(VowelOrdered.vowelStatus);
		Assert.assertEquals(VowelOrdered.vowelStatus,"Not-Ordered");
	}
	
	@Test
	public void test3() {
		int count = vowelOrdered.testWord("ABC");
		System.out.println(count);
		Assert.assertEquals(1,count);
		System.out.println(VowelOrdered.vowelStatus);
		Assert.assertEquals(VowelOrdered.vowelStatus,"Ordered");
	}
	
	@Test
	public void test4() {
		int count = vowelOrdered.testWord("Keep");
		System.out.println(count);
		Assert.assertEquals(2,count);
		System.out.println(VowelOrdered.vowelStatus);
		Assert.assertEquals(VowelOrdered.vowelStatus,"Ordered");
	}

	@Test
	public void test5() {
		int count = vowelOrdered.testWord("Ended");
		System.out.println(count);
		Assert.assertEquals(2,count);
		System.out.println(VowelOrdered.vowelStatus);
		Assert.assertEquals(VowelOrdered.vowelStatus,"Ordered");
	}
	
	@Test
	public void test6() {
		int count = vowelOrdered.testWord("Ending");
		System.out.println(count);
		Assert.assertEquals(2,count);
		System.out.println(VowelOrdered.vowelStatus);
		Assert.assertEquals(VowelOrdered.vowelStatus,"Ordered");
	}

}
