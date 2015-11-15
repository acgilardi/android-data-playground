package com.appmite.androiddataplayground.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseInitializer extends SQLiteOpenHelper{
	
    public static String DB_PATH = "/data/data/com.appmite.androiddataplayground/databases/";
    public static String DB_NAME = "db.sqlite";
    public static final int DB_VERSION = 1;
    File dbFile;
 
    private SQLiteDatabase database; 
    private final Context context;
    
    public DatabaseInitializer(Context context) 
    {
    	super(context, DB_NAME, null, 1);
        this.context = context;
        this.dbFile = new File(DB_PATH + DB_NAME);
    }	
    
    public void createDatabase() throws IOException
    {
    	
    	//boolean dbExist = checkDatabase();
 
    	if(!dbFile.exists()){
        	SQLiteDatabase db = this.getReadableDatabase();
        	try {
    			copyDatabase(db.getPath());
    		} catch (IOException e) {
        		throw new Error("Error copying database");
        	}
    	}
 
    }
//    private boolean checkDatabase(){
// 
//    	SQLiteDatabase checkDB = null;
// 
//    	try{
//    		String myPath = DB_PATH + DB_NAME;
//    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
// 
//    	}catch(SQLiteException e){ 
//    		//throw new Error("Error checking for database");
//    	}
// 
//    	if(checkDB != null){
//    		checkDB.close();
//    	}
// 
//    	return checkDB != null ? true : false;
//    }
    private void copyDatabase(String dbPath) throws IOException{
    	
    	InputStream myInput = context.getAssets().open(DB_NAME);
    	
    	//String outFileName = DB_PATH + DB_NAME;
    	
    	OutputStream myOutput = new FileOutputStream(dbPath, false);
    	//OutputStream myOutput = new FileOutputStream(outFileName);
    	
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
    	
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    @Override
	public synchronized void close() {
	    if(database != null)
		    database.close();
	    
	    super.close();
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
 
}
