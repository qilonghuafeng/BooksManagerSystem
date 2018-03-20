package com.atguigu.view;

import com.atguigu.Library;
import com.atguigu.utils.CMUtility;

public class View {
	Library lb = new Library();
	boolean loop = true;

	public void enterView() {
		do {
			System.out.println("------------图书管理系统------------");
			System.out.println("1.查看图书\n2.添加图书\n3.修改图书(按编号)\n" + "4.删除图书(按编号)\n5.图书排序(按价格)\n6.退出");
			System.out.println("...");
			System.out.print("请选择：");
			char key = CMUtility.readMenuSelection();
			switch (key) {
			case '1':
				lb.searchBooks();
				break;
			case '2':
				lb.putBooks();
				break;
			case '3':
				lb.replaceBooks();
				break;
			case '4':
				lb.deleteBooks();
				break;
			case '5':
				lb.sortBooks();
				break;
			case '6':
				loop = lb.isExit();
				break;
			}
		} while (loop);
	}

}
