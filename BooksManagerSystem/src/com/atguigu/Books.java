package com.atguigu;

/*
 * 1、要求定义一个图书类：包括编号书名，作者和价格进行封装
 */
public class Books implements Comparable {
	private int id;// 编号
	private String name;// 书名
	private String author;// 作者
	private int price;// 价格

	public Books(int id, String name, String author, int price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int hsahCode() {
		return name.hashCode() + (int) price * 31;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Books))
			return false;
		Books book = (Books) obj;
		if (this.name.equals(book.name) && this.price == book.price)
			return true;
		return false;
	}

	public String toString() {
		return id + "\t" + name + "\t" + author + "\t" + price;
	}

	public Books(String name, String author, int price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Object o) {
		Books book1 = (Books) o;
		if (this == book1)
			return 0;
		if (this.getPrice() > book1.getPrice())
			return -1;
		if (this.getPrice() > book1.getPrice())
			return 1;
		return 1;
	}
}
