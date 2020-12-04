
package unpacker;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.scene.control.TreeItem;

public class Unpacker {
//this is where data is loaded into, so that it can be used to create the table contents from it.

	public void Unpack(Reader r, TreeItem treeItem) {
		String JSONstring = r.getJson();

		JSONObject jobj = new JSONObject(JSONstring);
		AddObject(jobj, treeItem);
	}

	private void AddObject(JSONObject object, TreeItem treeItem) {
		Set<String> keys = object.keySet();

		for (String key : keys) {
			Object child = object.get(key);
			if (child instanceof JSONObject) {
				TreeItem newRoot = new TreeItem(key);
				treeItem.getChildren().add(newRoot);
				AddObject((JSONObject) child, newRoot);
				// Recurse
			} else if (child instanceof JSONArray) {
				JSONArray array = (JSONArray) child;
				for (int i = 0; i < array.length(); i++) {
					TreeItem arrayChild = new TreeItem(i);
					treeItem.getChildren().add(arrayChild);
					
					Object nextChild = array.get(i);
					if(nextChild instanceof JSONObject)
					{
						AddObject((JSONObject)nextChild, arrayChild);
					}
					else
					{
						AddProperty(nextChild, arrayChild);	
					}

				}
				// handle all children of child
			} else {
				// is property?
				AddProperty(key, child, treeItem);
			}
		}

	}
	
	private void AddProperty(Object prop, TreeItem treeItem) {
		TreeItem property = new TreeItem(prop.toString());
		treeItem.getChildren().add(property);
	}
	private void AddProperty(String key, Object prop, TreeItem treeItem) {
		TreeItem property = new TreeItem(key + " : " + prop.toString());
		treeItem.getChildren().add(property);
	}
}
