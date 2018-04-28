package it.dan;
import java.io.File;
import it.dan.model.Item;
import it.dan.service.ItemFileManager;
public class AppRunner {
    public static void main(String[] args) {
        String sep = System.getProperty("file.separator");
        String appDir = "C:" + sep + "test";
        
        String filePath = appDir+sep+"test.txt";
        
        Item item = ItemFileManager.readItemFromFile(filePath);
        
        File file = item.getImg();
        
        ItemFileManager.saveFile(file, appDir + sep + "newFile.jpeg");
        
        
        // String filePath = appDir+sep+"test.txt";
        //
        // Item item = new Item("artId1", "My favorite item", 3000, new
        // File("C:"+sep+"test\\js.jpeg"));
        //
        // ItemFileManager.saveItemToFile(item, filePath);
        // ItemFileManager.copy("C:" + sep + "test\\js.jpeg", "C:" + sep +
        // "test\\js_copy.jpeg");
    }
}