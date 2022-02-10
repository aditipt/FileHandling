package pack1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Demo {
	public static Boolean createFile()
	{
		
		try
		{
			File f = new File("C:\\Users\\DELL\\Documents\\Assisted Projects\\Sample2.txt");
			if(f.createNewFile())
			{
				System.out.println("File Created Successfully!!!!!");
			}
			else
			{
				System.err.println("File Already Exists!!!!!!");
			}
		}
		catch(IOException e)
		{
			System.out.println("Exception occured "+e);
			return false;
		}


		try
		{
			File f1 = new File("C:\\Users\\DELL\\Documents\\Assisted Projects\\Sample2.txt");
			FileWriter writer= new FileWriter(f1);
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter the message : ");
			String ms = sc1.nextLine();
			writer.write(ms);
			writer.close();
			if(f1.canWrite())
				System.out.println("Content present in the File  : "+ms);
		}
		catch(IOException e)
		{
			System.out.println("Exception Has Occured ");
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static List<String> readFile(String fileName)
	{
		List<String> list= Collections.emptyList();
		try {
			list= Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	public static void appendFile(String fileName, String str) throws IOException {
		try {
		   BufferedWriter bf = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Documents\\Assisted Projects\\Sample2.txt", true));
		   bf.write(str);
		   bf.close();
	   }
	   catch (IOException e) {
		   System.out.println("Exception Has Occurred");
		   System.out.println(e);
	   }
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Program Started");
		Scanner sc1 = new Scanner(System.in);
		
		while(true)
		{
            System.out.println("-------File Operations-------");
			System.out.println("1. Create and Write");
			System.out.println("2. Read ");
			System.out.println("3. Append ");
			System.out.println("4. Close");
			System.out.println("Enter the Operation : ");
			int ch = sc1.nextInt();
			
			if(ch == 1)
			{
				createFile();
			}
			
			else if(ch == 2)
			{
				List<String> rs= readFile("C:\\Users\\DELL\\Documents\\Assisted Projects\\Sample2.txt");
				Iterator<String> it= rs.iterator();
				System.out.println();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
			}
			
			else if(ch == 3)
			{
				Scanner sc= new Scanner(System.in);
				System.out.println("Enter string which you to append : ");
				String data = sc.nextLine();
				appendFile("C:\\Users\\DELL\\Documents\\Assisted Projects\\Sample2.txt", data);
			}
			
			else if(ch == 4)
			{
				System.out.println("Thank You!!!!!");
				break;
			}
			
			else
			{
				System.out.println("Please Enter correct choice!!!!");
			}
		}
		sc1.close();
		
		System.out.println("Program Ended");
	}
}




