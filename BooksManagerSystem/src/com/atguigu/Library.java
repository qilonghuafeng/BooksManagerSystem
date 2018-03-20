package com.atguigu;

import java.util.*;

import com.atguigu.utils.CMUtility;
import com.atguigu.utils.TSUtility;

/*
 * 2、要求定义一个图书馆类，在图书馆类中要求能够对图书信息进行查询：
      按照编号查询，也可以按照书名查询
3、在图书馆类中要求能够对新增图书
4、在图书馆类中要求能够对图书信息，。按照编号进行修改
5、在图书馆类中要求能够对图书信息，。按照编号进行删除
6、在图书馆类中要求能够对图书信息按照价格由高到低的次序显示输出。
7、要求书名和价格完全一样的是同一本书
 */
public class Library {
	int id = 1;
	TreeMap tp = new TreeMap(new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			Books book1 = (Books) o1;
			Books book2 = (Books) o2;
			return (int) (book2.getPrice() - book1.getPrice());
		}
	});

	// 查看图书，按编号查找，按书名查找
	public void searchBooks() {
		System.out.print("请问是按书名查找还是按编号查找\n1.书名2.编号\n请输入");
		char key = CMUtility.readMenuSelection001();
		Set set = tp.keySet();
		switch (key) {
		case '1':
			System.out.print("请输入您要查找的书名：");
			String name = CMUtility.readString(32);
			for (Object obj : set) {
				Books book = (Books) (obj);
				if (book.getName().equals(name)) {
					System.out.println("您所查找的书的详情如下：");
					System.out.println("编号\t书名\t作者\t价格");
					System.out.println(book);
					TSUtility.readReturn();
					return;
				}
			}
			System.out.println("您找的书目前没有或者输入有误\n如有需要，请联系管理员");
			TSUtility.readReturn();
			break;

		case '2':
			System.out.print("请输入您要查找的书的编号：");
			int id = TSUtility.readInt();
			for (Object obj : set) {
				Books book = (Books) (obj);
				if (book.getId() == id) {
					System.out.println("您所查找的书的详情如下：");
					System.out.println("编号\t书名\t作者\t价格");
					System.out.println(book);
					TSUtility.readReturn();
					return;
				}
			}
			System.out.println("您找的书目前没有或者您的编号输入有误\n如有需要，请联系管理员");
			TSUtility.readReturn();
			break;
		}
	}

	// 添加图书的信息
	public void putBooks() {
		// 包括编号书名，作者和价格进行封装
		System.out.print("请输入要添加图书的书名：");
		String name = CMUtility.readString(32);
		System.out.print("请输入要添加图书的作者：");
		String author = CMUtility.readString(32);
		System.out.print("请输入要添加图书的价格：");
		int price = CMUtility.readInt();
		Books book = new Books(name, author, price);
		tp.put(book, id);
		System.out.println("添加成功");
		book.setId(id++);
		TSUtility.readReturn();
	}

	// 删除图书的信息
	public void deleteBooks() {
		System.out.print("请输入要删除的图书编号：");
		int id6 = TSUtility.readInt();
		Set set = tp.keySet();
		for (Object obj : set) {
			Books book = (Books)obj;
			if (book.getId()==id6) {
				tp.remove(book);
				System.out.println("删除成功");
				TSUtility.readReturn();
				return;
			}
		}
		System.out.println("删除失败");
		TSUtility.readReturn();

	}

	// 修改图书信息
	public void replaceBooks() {
		System.out.print("请输入要修改图书的编号：");
		int id8 = TSUtility.readInt();
		Set set = tp.keySet();
		for (Object obj : set) {
			Books book = (Books) (obj);
			if (book.getId() == id8) {
				tp.remove(book);
				System.out.print("请修改图书的书名：");
				String name = CMUtility.readString(32, book.getName());
				System.out.print("请修改图书的作者：");
				String author = CMUtility.readString(32, book.getAuthor());
				System.out.print("请修改图书的价格：");
				int price = CMUtility.readInt(book.getPrice());
				book = new Books(name, author, price);
				book.setId(id8);
				tp.put(book, id8);
				System.out.println("修改成功");
				TSUtility.readReturn();
				return;
			}
		}
		System.out.println("修改失败");
		TSUtility.readReturn();
	}

	// 按价格排序显示图示信息
	public void sortBooks() {
		System.out.println("编号\t书名\t作者\t价格");
		Set keys = tp.keySet();
		for (Object key : keys) {
			System.out.println(key);
		}
		TSUtility.readReturn();
	}

	// 退出程序
	public boolean isExit() {
		System.out.print("确认要退出吗？(y/n)");
		char key = TSUtility.readConfirmSelection();
		if ('y' == key) {
			System.out.println("程序结束");
			return false;
		}
		return true;
	}

}
