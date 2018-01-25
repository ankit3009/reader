package SeleniumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FieldValue {

	Properties prop ;
	public String linkAUT;
	public String expectedTitle;
	public String inputTextBoxName;
	public String inputBtnName;
	public FieldValue() throws IOException {
		System.out.println("FieldValue constructor entry");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\SeleniumUtils\\Fields.properties");
		prop.load(fis);
		System.out.println("FieldValue constructor exit");
	}
	
	public void initializeFields() {
		linkAUT =  prop.getProperty("LinkTestApplication");
		expectedTitle=prop.getProperty("ExpectedTitle");
		inputTextBoxName=prop.getProperty("inputTextBoxName");
		inputBtnName=prop.getProperty("inputBtnGoogleSrchName");
	}
}
