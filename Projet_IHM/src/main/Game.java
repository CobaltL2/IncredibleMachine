package main;

import objects.*;
import java.io.*;
import java.util.*;

public class Game {

	private HashMap<Object,Integer> availableObjects;
	private ArrayList<Object> placedObjects;
	
	public Game(int l) {
		/** Edit the hashmap to not use objects **/
		placedObjects = new ArrayList<Object>();
	/**	availableObjects = new HashMap<Object,Integer>();
		File levelFile = new File("level"+l+".txt");
		try {
			FileReader fr = new FileReader(levelFile);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				/** Parsing des objets par défaut **/
	/**		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} **/
		placedObjects.add(new BaseBall(100,100,this));
		placedObjects.add(new Scissors(100,500,0,this));
		placedObjects.add(new Balloon(200,500,this));
		placedObjects.add(new Scissors(200,200,1,this));
		start();
	}
	
	public void start() {
		for (Object a : placedObjects) {
			a.start();
		}
	}
	
	public ArrayList<Object> getObjects() {
		return this.placedObjects;
	}

}
