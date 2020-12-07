package unpacker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//this class reads data and sends it to the unpacker(?)
public class Reader {
	
	public String getJson () {
		File directory = new File("./unpacker/src/");
		   System.out.println(directory.getAbsolutePath());
		//URL url = getClass().getResource("Test.json");
		try {
			return Files.readString(Path.of(".\\src\\unpacker\\Test.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
}
	
