package unpacker;

import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.*;

public class Reader {
	
	public String getJson () {
		String jsonString = "";
		try (Scanner scanner = new Scanner(new File("TEST.json"));) {
			while (scanner.hasNext()) {

				jsonString += scanner;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			}
		return jsonString;
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
