package com.github.cnname.core;

import com.github.cnname.core.exception.NameTooLongException;
import com.github.cnname.core.exception.NoSuchNameTypeException;

/**
 * Created by Administrator on 2016/12/2.
 */
public class CNNameFactory {

	private Boolean genderType = GenderType.Female;

	private int nameType = NameType.SingleFirstName;

	private int nameLength = 2;

	private ChineseFirstName chineseFirstName = new ChineseFirstName();

	private ChineseLastName chineseLastName = new ChineseLastName();

	public CNNameFactory(){
	}


	public CNNameFactory setGenderType(Boolean genderType){
		this.genderType = genderType;
		return this;
	}
	public CNNameFactory setNameType(int nameType){
		this.nameType = nameType;
		return this;
	}
	public String create(){
		try {
			return this.chineseFirstName.generateRandom(nameType) + this.chineseLastName.generateRandom(genderType,nameLength-1);
		} catch (NoSuchNameTypeException e) {
			e.printStackTrace();
		} catch (NameTooLongException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CNNameFactory setNameLength(int nameLength){
		this.nameLength = nameLength;
		return this;
	}

	public static void main(String[] args) {
		CNNameFactory cnNameFactory = new CNNameFactory();
		String name = cnNameFactory.create();
		System.out.println(name);
	}
}
