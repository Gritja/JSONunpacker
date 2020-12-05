package unpacker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Users {
	
	//hanterar inlogg/användare-lösen

    //private String userName = null;
    //private String passWord = null;
	
	//gör kolla-igenom-lista metod för att korta av repetitioner(?) med pw check så kan en förmodligen skicka in userNo fr positionen i listan.
	//private ArrayList<String> userList;

    public static boolean loginUser(String userName, String passWord) {
		boolean allGood = false;
    	try {
    		ArrayList<String> userList = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\astro\\eclipse-workspace\\JSONunpacker\\src\\unpacker\\userpw.txt")));

    		
    		for (String fromArray : userList) {
    			// ^^ går igenom ALLA strängar i listan och gör samma koll - behöver uppenbarligen sätta ett stopp när den hitta användaren och sen göra kollen.
        		if (fromArray.contains(userName)) {
        			//log
        			if (fromArray.contains(passWord)) {
        				//log
        				System.out.print("User and pass accepted!");
        				allGood = true;
        			} else {
        				//javafx prompt!
        				System.out.println("Invalid password!");
        			}
        		} else {
        			// javafx prompt!
        			System.out.println(fromArray);
        			//log
        			for (int i = 0; i < userList.size(); i++) {
        				System.out.println(userList.get(i));
        			}
        			
        			System.out.println("Invalid email!");
        		}
        	}
    	} catch (IOException e) {
    		
    	}
    	//log
    	System.out.print("Ran!");
		return allGood;

    }

	public static void addUser(String userName, String passWord) {
		try {
			ArrayList<String> userList = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\astro\\eclipse-workspace\\JSONunpacker\\src\\unpacker\\userpw.txt")));
			int userNo = userList.size();
			boolean userExists = false;
			
			//check substrings in arraylist for user name. could be a separate method that returns true... but I figure this is fine too.
			for (String fromArray : userList) {
				if (fromArray.contains(userName)) {
					userExists = true;
				}
			}
			if (!userExists) {
			userList.add(++userNo + ": " + userName + ", " + passWord);
			Path updateList = Paths.get("C:\\Users\\astro\\eclipse-workspace\\JSONunpacker\\src\\unpacker\\userpw.txt");
			Files.write(updateList,userList,Charset.defaultCharset());
			
			} else {
				//add fx prompt "user already exists!"
				System.out.println("User already exists!");
			}
			//log
			for (int i = 0; i < userList.size(); i++) {
				System.out.println(userList.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}