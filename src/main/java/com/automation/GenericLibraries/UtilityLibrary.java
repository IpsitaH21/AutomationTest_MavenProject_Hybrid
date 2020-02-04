package com.automation.GenericLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityLibrary {
	
			
		 String filepath="./Config_Data/ConfigFile.properties";
		 		 
		 public Properties getpropertiesfileobject() throws IOException
		 {
			 FileInputStream fis=new FileInputStream(filepath);
			 Properties pobj=new Properties();
			 pobj.load(fis);
			 
			 return pobj;
			 
		 }

}
