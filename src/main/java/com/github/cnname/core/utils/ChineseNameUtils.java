package com.github.cnname.core.utils;

import com.github.cnname.core.CNNameFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
public class ChineseNameUtils {

	private final static CNNameFactory cnNameFactory = new CNNameFactory();

	private ChineseNameUtils(){
	}
	public static List<String> randomCNNameList(int size){
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < size ; i ++)
			list.add(cnNameFactory.create());
		return list;
	}

	public static void main(String[] args) {
		List<String> list = ChineseNameUtils.randomCNNameList(100);
		for (int i = 0 ; i < list.size() ; i++)
		{
			System.out.println(list.get(i));
		}
	}
}
