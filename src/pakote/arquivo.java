package pakote;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileReader;
import java.io.FileWriter;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javax.swing.JFileChooser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class arquivo {
    String path;
    File file;
    JSONObject jsonObject = new JSONObject();
    JSONObject jsonObject2;
    FileWriter writeFile = null;
    JSONParser parser = new JSONParser();
    File config = new File("Cofig.txt");
   
    public void SetPath(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Selecione o path");
            File selectedDirectory = chooser.showDialog(Main.GetStage());
            path = selectedDirectory.getAbsolutePath();
            System.out.println(path);
        if(config.exists()){
            config.delete();
            try {
                              config.createNewFile();
                FileWriter fw = new FileWriter(config, true);
                fw.write(path);
                fw.close();  
            } catch (Exception e) {
            }
{
            }
        } else{
        try {
            config.createNewFile();
            FileWriter fw = new FileWriter(config, true);
            fw.write(path);
            fw.close();
        } catch (Exception e) {}
        }
    }
    public void SetFile(String aFile){
        file = new File(path+"\\"+aFile);
    }
    public void ExisPath(){
        if(config.exists()==true){
            try {
                FileReader fr = new FileReader(config);
                BufferedReader br = new BufferedReader(fr);
                path=br.readLine();
                System.out.println(path);
                System.out.println("Lido");
                fr.close();
                br.close();
            } catch (Exception e) {
            }
        }
    }
    public void ListFile(ListView list){
        if(config.exists()){
            File dir = new File(path);
            for(File file:dir.listFiles()){
                list.getItems().addAll(file.getName());
            }
        }
    }
    public void CreateFile(String name){
        try {
        file = new File(path+"\\"+name+".json");
        file.createNewFile();
        } catch (Exception e) {}
    }
    public void DeleteFile(String name) {
    	try {
                        file = new File(path+"\\"+name);
			file.delete();
		} catch (Exception e) {}
    }
    public void WriteFile(String type, String value) {
    	jsonObject.put(type, value);
    	try {
        	writeFile = new FileWriter(file);
			writeFile.write(jsonObject.toJSONString());
			writeFile.close();
		} catch (Exception e) {}
    }
    public String ReadFile(String type) {
    	String read;
    	try {
    		jsonObject2 = (JSONObject) parser.parse(new FileReader(file));
    		read = (String) jsonObject2.get(type);
		} catch (Exception e) {}
        return (String) jsonObject2.get(type);
    }
}
