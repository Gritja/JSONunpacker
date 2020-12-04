package unpacker;

import javafx.scene.control.TableView;
import java.nio.file.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.json.*;
import org.json.*;

public class Reader {
	
	public String getJson () {
		
		try {
			return Files.readString(Path.of("C:\\Users\\astro\\eclipse-workspace\\JSONunpacker\\src\\unpacker\\Test.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
}
	
//this class reads data and sends it to the unpacker(?)
	
//	public void readJSON () {
//		 final TableView<String[]> tableView = new TableView<String[]>();
//		 DataSourceReader reader = new FileSource(getClass().getResourceAsStream("Test.json"));
//		 ObjectDataSourceBuilder builder = ObjectDataSourceBuilder.create()
//		         .itemClass(JSONunpacker.Tweet.class).dataSourceReader(reader)
//		         .columns("author","text")
//		         .itemTag("results").format(Format.JSON);
//		 ObjectDataSource ds = builder.build();
//		 ds.retrieve();
//		 tableView.setItems(ds.getData());
//		 tableView.getColumns().addAll(ds.getColumns());
//	}
