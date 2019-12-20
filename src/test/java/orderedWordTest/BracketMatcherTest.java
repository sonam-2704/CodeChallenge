package orderedWordTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.CodeChallenge.BracketMatcher;

public class BracketMatcherTest {

	private BracketMatcher bracketMatcher;
	@Before
	public void beforeTest() {
		bracketMatcher = new BracketMatcher();
	}
	
	@Test
	public void test1() {
		bracketMatcher.findBalancedExpression("<some[random]<text>(here)>");
		Assert.assertEquals("Balanced", bracketMatcher.isBalancedExpression);
		Assert.assertEquals(4, bracketMatcher.matchCount);
	}
	
	@Test
	public void test2() {
		bracketMatcher.findBalancedExpression("<two>{pairs}before.mismatch(");
		Assert.assertEquals("Not Balanced", bracketMatcher.isBalancedExpression);
		Assert.assertEquals(2, bracketMatcher.matchCount);
	}
	
	@Test
	public void test3() {
		bracketMatcher.findBalancedExpression("]yet(another)");
		Assert.assertEquals("Not Balanced", bracketMatcher.isBalancedExpression);
		Assert.assertEquals(1, bracketMatcher.matchCount);
	}
	
	@Test
	public void test4() {
		bracketMatcher.findBalancedExpression("<and>yet(another[one)");
		Assert.assertEquals("Not Balanced", bracketMatcher.isBalancedExpression);
		Assert.assertEquals(2, bracketMatcher.matchCount);
	}
	
}
