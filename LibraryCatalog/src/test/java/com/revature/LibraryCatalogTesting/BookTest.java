package com.revature.LibraryCatalogTesting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.LibraryCatalog.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = )
public class BookTest {

	@Test
	public void testBook() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals(new Book(1, "t", "a", 123, 100, 101, 102, "i", "d"), b);
	}

	@Test
	public void testGetBookID() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals(1, b.getBookID());
	}

	@Test
	public void testSetBookID() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setBookID(2);
		Assert.assertEquals(2, b.getBookID());
	}

	@Test
	public void testGetTitle() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals("t", b.getTitle());
	}

	@Test
	public void testSetTitle() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setTitle("Title");
		Assert.assertEquals("Title", b.getTitle());
	}

	@Test
	public void testGetAuthor() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals("a", b.getAuthor());
	}

	@Test
	public void testSetAuthor() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setAuthor("Author");
		Assert.assertEquals("Author", b.getAuthor());
	}

	@Test
	public void testGetIBSN() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals(123, b.getIBSN());
	}

	@Test
	public void testSetIBSN() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setIBSN(456);
		Assert.assertEquals(456, b.getIBSN());
	}

	@Test
	public void testGetKeyword1() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals(100, b.getKeyword1());
	}

	@Test
	public void testSetKeyword1() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setKeyword1(200);
		Assert.assertEquals(200, b.getKeyword1());
	}

	@Test
	public void testGetKeyword2() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals(101, b.getKeyword2());
	}

	@Test
	public void testSetKeyword2() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setKeyword2(201);
		Assert.assertEquals(201, b.getKeyword2());
	}

	@Test
	public void testGetKeyword3() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals(102, b.getKeyword3());
	}

	@Test
	public void testSetKeyword3() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setKeyword3(202);
		Assert.assertEquals(202, b.getKeyword3());
	}

	@Test
	public void testGetCoverimageurl() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals("i", b.getCoverimageurl());
	}

	@Test
	public void testSetCoverimageurl() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setCoverimageurl("Image");
		Assert.assertEquals("Image", b.getCoverimageurl());
	}

	@Test
	public void testGetDescription() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		Assert.assertEquals("d", b.getDescription());
	}

	@Test
	public void testSetDescription() {
		Book b = new Book(1, "t", "a", 123, 100, 101, 102, "i", "d");
		b.setDescription("Desription");
		Assert.assertEquals("Desription", b.getDescription());
	}

}
