package com.github.cnname.core;

import com.github.cnname.core.exception.NameTooLongException;

import java.util.Random;

/**
 * Created by Administrator on 2016/12/2.
 */
public class ChineseLastName implements  ChineseName{

	private String lastName;

	private Random random;

	public String generateRandom() {
		int index = random.nextInt(NamesConstants.LastNameCharsLength);
		this.lastName = NamesConstants.LastNameChars[index] + "";
		return lastName;
	}

	public String generateRandom(Boolean GenderType) {
		if(GenderType)
			return generateRandomForFemale();
		else
			return generateRandomForMale();
	}
	private String generateRandomForMale() {
		int index = random.nextInt(NamesConstants.maleLastNameCharsLength);
		return NamesConstants.maleLastNameChars[index] + "";
	}


	private String generateRandomForFemale() {
		int index = random.nextInt(NamesConstants.femaleLastNameCharsLength);
		return NamesConstants.femaleLastNameChars[index] + "";
	}

	public String generateRandom(Boolean genderType,int length) throws NameTooLongException {
		if(length > 2)
			throw new NameTooLongException("lastname range from 1~2");
		else
		{
			this.lastName = "";
			for(int i = 0 ; i < length ; i++)
				this.lastName += generateRandom(genderType);
		}
		return lastName;
	}

	public ChineseLastName() {
		this.random = new Random(System.currentTimeMillis());
		this.lastName = "";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static void main(String[] args) throws NameTooLongException {
		ChineseLastName chineseLastName = new ChineseLastName();
		String ming = chineseLastName.generateRandom(GenderType.Female,2);
		String ming2 = chineseLastName.generateRandom(GenderType.Female,2);
		String ming3 = chineseLastName.generateRandom(GenderType.Female,2);
		String ming4 = chineseLastName.generateRandom(GenderType.Female,2);
		String ming5 = chineseLastName.generateRandom(GenderType.Female,2);
		System.out.println(ming);
		System.out.println(ming2);
		System.out.println(ming3);
		System.out.println(ming4);
		System.out.println(ming5);
	}
}
