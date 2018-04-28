package it.dan.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import it.dan.model.Item;

public class ItemFileManager {
	
	public static void saveItemtoFile(Item item, String filePath) {
		
		File file = new File(filePath);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(item);
			oos.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static Item readItemFromFile(String filePath) {
		Item item = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			item = (Item) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public static void copy(String source, String target){
        
        FileOutputStream fos = null;
        
        try {
            byte[] data = Files.readAllBytes(new File(source).toPath());
            
            fos = new FileOutputStream(target);
            fos.write(data);
            fos.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void saveFile(File source, String target){
        
        FileOutputStream fos = null;
        
        try {
            byte[] data = Files.readAllBytes(source.toPath());
            
            fos = new FileOutputStream(target);
            fos.write(data);
            fos.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

