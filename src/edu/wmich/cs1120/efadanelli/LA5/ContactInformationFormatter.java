package edu.wmich.cs1120.efadanelli.LA5;

import java.io.*;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
	
	File[] files = new File[10];
	FormatExceptionHandler problemSolver = new FormatExceptionHandler();
	int[] phoneNumberArray = new int[10];
	String[] kimJongUn = new String[3];
	@Override
	public void readContactInformation(String[] filePaths) {
		formatName(filePaths[0]);
		formatPhoneNumber(filePaths[1]);
		formatEmail(filePaths[2]);
		
	}

	@Override
	public void formatContactInformation(String fileName) {
	Scanner peanut = new Scanner(fileName);
		kimJongUn[0] = peanut.nextLine();
		kimJongUn[1] = peanut.nextLine();
		kimJongUn[2] = peanut.nextLine();
		
	}

	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		
		for(int i = 0; i<email.length()-1; i++);)
			{
					char cheese = email.charAt(i);	
					if(cheese > 64 || cheese < 91)
					{
						
						throw EmailAddressFormatException(email);
					
					}
					
					
					
			}
		
	}

	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		int numberForTheArray = 0;
	
			for(int a = 0; a< phoneNumber.length()-1; a++){
				char pasta = phoneNumber.charAt(a);
				switch(pasta) {
				case 48: phoneNumberArray[numberForTheArray] = 0;
					numberForTheArray++;
					break;
				case 49: phoneNumberArray[numberForTheArray] = 1;
					numberForTheArray++;
					break;
				case 50: phoneNumberArray[numberForTheArray] = 2;
					numberForTheArray++;
					break;
				case 51: phoneNumberArray[numberForTheArray] = 3;
					numberForTheArray++;
					break;
				case 52: phoneNumberArray[numberForTheArray] = 4;
					numberForTheArray++;
					break;
				case 53: phoneNumberArray[numberForTheArray] = 5;
					numberForTheArray++;
					break;
				case 54: phoneNumberArray[numberForTheArray] = 6;
					numberForTheArray++;
					break;
				case 55: phoneNumberArray[numberForTheArray] = 7;
					numberForTheArray++;
					break;
				case 56: phoneNumberArray[numberForTheArray] = 8;
					numberForTheArray++;
					break;
				case 57: phoneNumberArray[numberForTheArray] = 9;
					numberForTheArray++;
					break;
				default: System.out.println("The char was not a number!");
					throw PhoneNumberFormatException();
					break;
				}
			}
		}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		boolean secondWord = false;
		try {
			for(int stringIndex=0;stringIndex <= name.length()-1;stringIndex++) {
				char thisChar = name.charAt(stringIndex);
				if(thisChar == ' ') {//check to see if were at the second word
					secondWord = true;//if we are set the space true (the next letter must be capitalized
					continue;//go to next letter
				}else {//otherwise check to see if its the first or second word cap. letter
					if(stringIndex == 0 || secondWord) {//if it is
						secondWord = false;//set secondWord to false
						if(thisChar < 65 || thisChar > 90) //if the character is not capital letter
							throw new NameFormatException(name);//throw NameFormatexception and use handler to handle it
					}else {//otherwise check to see if its a lowerCase letter
						if(thisChar < 97 || thisChar > 122) //if the character is not lowerCase letter
							throw new NameFormatException(name);//throw NameFormatexception and use handler to handle it
					}
				}
			}
			System.out.println("Correct Format was entered: " + name);//GET RID OF THIS LINE EVENTUALLY
		}catch(NameFormatException e) {	
			System.out.print("There was an incorrect format: " + name + "\nCorrect format: ");
			problemSolver.handleNameFormatException(e);
		}
	}
}