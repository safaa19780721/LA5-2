package edu.wmich.cs1120.efadanelli.LA5;

public class Main {

	public static void main(String[] args) throws NameFormatException, PhoneNumberFormatException,EmailAddressFormatException {
		String[] filePaths = {"testcase1.txt","testcase2.txt", "testcase3.txt", "testcase4.txt", "testcase5.txt", "testcase6.txt", "testcase7.txt", "testcase8.txt", "testcase9.txt", "testcase10.txt"};
		ContactInformationFormatter formatter = new ContactInformationFormatter();
		formatter.readContactInformation(filePaths);
	}
}