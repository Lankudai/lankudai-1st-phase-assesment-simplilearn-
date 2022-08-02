import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

	public class LockedMe{
		// TODO Auto-generated method stub
		static String DIRECTORY;
		File folder_name;
		public LockedMe() {
		DIRECTORY = System.getProperty("user.dir");
		folder_name = new File(DIRECTORY+"/files");
		if(!folder_name.exists())
		folder_name.mkdirs();
		System.out.println("DIRECTORY:"+ folder_name.getAbsolutePath());
		
		
		}
	
		
		private static final String MAIN_MENU_PROMPT =
				"\n MAIN MENU -- CHOOSE YOUR OPTION:\n"+
					    "1 -- The List of Files in Directory\n"+
						"2 -- Choose ADD,Delete or Search\n"+
						"3 -- Close the Program ";
		
		private static final String SECONDARY_MENU_PROMPT =
				"\n  SELECT YOUR OPTION:\n"+
						" a-- Add a file\n"+
						" b-- Delete a file\n"+
						" c-- Search for a file\n"+
						" d-- Previous Menu";
		void showPrimaryMenu() {
		System.out.println(MAIN_MENU_PROMPT);
		try {
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1:{
				
				showfiles();
				showPrimaryMenu();
				
			}
			
			case 2:{
			
				showSecondaryMenu1();
			}
			case 3:{
				System.out.println(" THANK YOU");
				System.exit(0);
			}
			default: showPrimaryMenu();
			
			}
		}
		catch (Exception e) {
			System.out.println(" enter any option 1 ,2,or 3");
			showPrimaryMenu();
		}
		}
	
	void showSecondaryMenu1() {
		System.out.println(SECONDARY_MENU_PROMPT);
		try {
			Scanner scanner = new Scanner(System.in);
			char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
			char option = input[0];
			switch(option) {
			case 'a':{
				System.out.println(" Adding a file -- Please enter a File name :");
				System.out.print("Adding a file-- please Enter a file name:");
				String filename = scanner.next().trim().toLowerCase();
				addFile(filename);
				break;
			}
			case 'b':{
				System.out.println(" Deleting a file-- Please enter a File name:");
				System.out.print(" Deleting a file-- Please enter a file name:");
				String filename = scanner.next().trim();
				deleteFile(filename);
				break;
			}
			case 'c':{
				System.out.println(" Searching a file -- Please enter a File name;");
				System.out.print(" Searching a file-- Please enter a file name:");
				String filename = scanner.next().trim();
				searchFile(filename);
				break;
				}
			case 'd': {
				System.out.println("Going back to previous MAIN MENU");
				showPrimaryMenu();
				break;
				
			}
			default : System.out.println("Please enter the either a,b,c, or d");
			}
			showSecondaryMenu();
		}
		catch (Exception e) {
			System.out.println("please enter 1,2,3 or 4");
			showSecondaryMenu();
		}
	}
	private void showSecondaryMenu() {
		// TODO Auto-generated method stub
		
	}
	void showfiles() {
		if (folder_name.list().length==0)
			System.out.println("The folder is empty");
		else {
			String[] list = folder_name.list();
			System.out.println("Files in "+ folder_name +" are :");
			Arrays.sort(list);
			for (String str:list) {
				System.out.println(str);
			}
		}
		
	}
	void addFile(String filename) throws IOException {
		File filepath = new File(folder_name+"/"+filename);
		String[] list = folder_name.list();
		for( String file: list) {
			if(filename.equalsIgnoreCase(file)) {
			System.out.println("File"+ filename+" already exists at "+ folder_name);
			return;
			}
		}
		filepath.createNewFile();
		System.out.println("File"+ filename+"already exists at" + folder_name);
		
	}
	void deleteFile(String filename) {
		// TODO Auto-generated method stub
		File filepath = new File(folder_name +"/"+filename);
		String[] list = folder_name.list();
		for(String file: list) {
			if(filename.equals(file)&& filepath.delete()) {
				System.out.println("File"+ filename+ "deletd from " +folder_name);
				return;
				
			}
		}
		
		System.out.println("Delete Operation failed. FNF -FILE NOT FOUND");
	}
	
		
		void searchFile(String filename) {
		
			String[] list = folder_name.list();
			for(String file: list) {
				if(file.equals(file)) {
					System.out.println("FILE : FOUND" +filename+ " exists at" +folder_name);
					return;
				}
			}
			System.out.println("FNF -- FILE NOT FOUND");
		}
		public static void main(String[] args) {
			System.out.println("\n----------WELCOME PROMPT-----------");
			System.out.println("\n ----------LockedMe.com--------");
			System.out.println("\n----------LANKUDAI--------------");
			
			LockedMe menu= new LockedMe();
			menu.showPrimaryMenu();
		}
}
		
	
		
				
		

	

		
			
		
