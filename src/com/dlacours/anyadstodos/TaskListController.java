package com.dlacours.anyadstodos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//Awesome singleton stuff
public class TaskListController {
	/*This class goes between Task and everything else.*/
	
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

	
	//I don't think I'm actually using these two methods
	public void addTask(Task task){
		getTaskList().addTask(task);
	}
	
	public void deleteTask(Task task){
		getTaskList().removeTask(task);
	}
}
