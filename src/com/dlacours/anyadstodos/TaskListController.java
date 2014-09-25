package com.dlacours.anyadstodos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//Awesome singleton stuff
public class TaskListController {

	private static final String FILENAME = "tasks.sav";
	private static ArrayList<Task> theTasks;
	private static TaskList taskList = null;
	private static TaskList unarchList = null;
	private static TaskList archList = null;
	
	static public TaskList getTaskList() {
		if (taskList == null){
			taskList = new TaskList();
		}
		return taskList;
	}

	static public TaskList getUnarchList() {
		if (unarchList == null){
			unarchList = new TaskList();
		}
		return unarchList;
	}
	
	static public TaskList getArchList() {
		if (archList == null){
			archList = new TaskList();
		}
		return archList;
	}
	/*
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader irs = new InputStreamReader(fis);
			
			// From www.javacreed.com/simple-gson-example/ 2014-25-09
			Gson myGson = new GsonBuilder().create();
			taskList = myGson.fromJson(irs, new TypeToken<ArrayList<Task>>() {}.getType()); //LOADING FROM FILE
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			Gson gson = new Gson(); //same as new Gson.Builder().create();
			gson.toJson(taskList, osw);
			osw.flush();
			osw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	
	
	
	
	//I don't think I'm actually using these two methods
	public void addTask(Task task){
		getTaskList().addTask(task);
	}
	
	public void deleteTask(Task task){
		getTaskList().removeTask(task);
	}
}
