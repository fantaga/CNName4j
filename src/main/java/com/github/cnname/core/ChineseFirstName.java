package com.github.cnname.core;

import com.github.cnname.core.exception.NameTooLongException;
import com.github.cnname.core.exception.NoSuchNameTypeException;

import java.util.Random;

/**
 * Created by Administrator on 2016/12/2.
 */
public class ChineseFirstName implements ChineseName {

	private String firstName;

	private Random random;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String generateRandom() {
		String temp = "";
		try {
			temp = generateRandom(NameType.SingleFirstName);
		} catch (NoSuchNameTypeException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public String generateRandom(Boolean GenderType) {
		return this.generateRandom();
	}

	public String generateRandom(int nameType) throws NoSuchNameTypeException {
		if (nameType == NameType.SingleFirstName)
			return generateRandomSingle();
		if(nameType == NameType.ComplexFirstName)
			return generateRandomComplex();
		else
			throw new NoSuchNameTypeException("NameType only can be single or complex");
	}

	private String generateRandomComplex() {
		int index = random.nextInt(NamesConstants.ComplexFirstNameLength);
		this.firstName = NamesConstants.ComplexFirstName[index];
		return firstName;
	}

	private String generateRandomSingle() {
		int index = random.nextInt(NamesConstants.firstNameCharsLength);
		this.firstName = NamesConstants.firstNameChars[index] + "";
		return firstName;
	}

	public ChineseFirstName() {
		random = new Random(System.currentTimeMillis());
		this.firstName = "";
	}

	public ChineseFirstName(String firstName) {
		this.firstName = firstName;
	}

	public static void main(String[] args) throws NameTooLongException {
		ChineseFirstName chineseFirstName = new ChineseFirstName();
		ChineseLastName chineseLastName = new ChineseLastName();
		try {
			for (int i = 0 ; i < 100 ; i++)
			{
				String xing = chineseFirstName.generateRandom(NameType.SingleFirstName);
				String ming = chineseLastName.generateRandom(GenderType.Male,1);
				System.out.println(xing + ming);
			}
		} catch (NoSuchNameTypeException e) {
			e.printStackTrace();
		}
	}
}
