package library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import book.AnyBook;
import book.Book;
import book.BookType;
import book.Magazine;
import member.*;

public class FileIO {
	
private static final String filePath = "./resources/items.csv";
	
	public void readItems(ArrayList<AnyBook> anyBookArrayList, ArrayList<Member> memberArrayList) {
		// Method that reads books that are borrowed by a customer.
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			String line;
			int idCounter = 1;
			while((line = bufferedReader.readLine()) != null) {
				String[] stringArray = line.split(";");
				LocalDate startDate = LocalDate.parse(convertForParsing(stringArray[7]));
				LocalDate endDate = LocalDate.parse(convertForParsing(stringArray[8]));
				BookType bookType = findBookType(stringArray[2]);
				// create a customer who has borrowed the item. 
				Member customer = createCustomer(idCounter, stringArray[6], startDate, endDate);
				memberArrayList.add(customer);
				
				if(stringArray[3].toLowerCase().equals("magazine")) {
					Magazine magazine = new Magazine(stringArray[0], stringArray[1], bookType,stringArray[4], stringArray[5]);
					anyBookArrayList.add(magazine);
				
				}else {
					Book book = new Book(stringArray[0], stringArray[1], bookType,stringArray[4], stringArray[5]);
					anyBookArrayList.add(book);
				}
				idCounter++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found!");
		} catch (IOException e) {
			System.err.println("File could not be read!");
		}
	}
	
	private String convertForParsing(String dateString) {
		String date[] = dateString.split("/");
		return date[2]+"-"+date[1]+"-"+date[0];
	}
	
	private BookType findBookType(String priorityName) {
		// method that finds book's type respect to priorityName.
		switch(priorityName.toLowerCase()) {
			case "highly significant":
				return BookType.HIGHLYSIGNIFICANT;
			case "noteworthy":
				return BookType.NOTEWORTHY;
			case "invaluable":
				return BookType.INVALUEABLE;
			default:
					throw new NullPointerException();
		}
	}
	
	private Member createCustomer(int id, String customerType, LocalDate startDate, LocalDate endDate) {
		Member member;
		switch(customerType.toLowerCase()) {
		case "general":
			member = new General(""+id, startDate, endDate);
			break;
		case "studentwscholar":
			member = new StudentWithScholar(""+id, startDate, endDate);
			break;
		case "studentwoscholar":
			member = new StudentWithoutScholar(""+id, startDate, endDate);
			break;
		default:
				throw new NullPointerException();
		}
		return member;
	}
}
