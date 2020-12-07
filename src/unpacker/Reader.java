package unpacker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//this class reads data and sends it to the unpacker(?)
public class Reader {
	
	public String getJson () {
		
		try {
			return Files.readString(Path.of("C:\\Users\\Jonatan\\eclipse-workspace\\JSONunpacker\\src\\unpacker\\Test.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
}
	
