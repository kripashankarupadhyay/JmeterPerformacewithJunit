package base;

/*import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import org.apache.log4j.Logger;*/
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPro.ReadExcel; 


	public class TestBase 

	{
		static WebDriver driver = null;
		static WebDriverWait wait;
		static int i = 0;
		
		/*private static Connection connection;
		private static Statement statement;
		private static ResultSet rs;	
		private static String sTestCaseName = null;
			
		private static final Logger logger = Logger.getLogger(TestBase.class.getName());*/
		
		
		public static  void loadlog4J(){
			String log4jConfPath = System.getProperty("user.dir")+"\\log4j.xml";
			PropertyConfigurator.configure(log4jConfPath);
		}
		
		/*public static void setTestcaseName(String sTCName) {
			sTestCaseName = sTCName;
		}*/
		
		
		public static WebDriver OpenBrowser(String browser, String sheet){
			 
		String url=base.ConstantClass.URLUA;
		//String DBName = base.Constant.DataBaseName;
		
	 
			try{
				if(browser.equals("chrome"))
				{					
					TestBase.loadlog4J();
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.get(url);
					driver.manage().window().maximize();
					//BaseClass.implicitTime(15, driver);
					//wait=new WebDriverWait(msm, 20);
					System.out.println("open browser Successfully !");
					//use excel file
					ReadExcel.setExcelFile(base.ConstantClass.Path_TestData + base.ConstantClass.File_TestData,sheet);
					//TestBase.setUp();
					
				}
				if(browser.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.get(url);
					driver.manage().window().maximize();
					//BaseClass.implicitTime(15, driver);
					//wait=new WebDriverWait(msm, 20);
					System.out.println("open browser Successfully !");
					//use excel file
					ReadExcel.setExcelFile(base.ConstantClass.Path_TestData + base.ConstantClass.File_TestData,sheet);
					//TestBase.setUp();
				}
			}
	 
			catch (Exception e)
			{
				System.out.println("Problem in open browser !");
				e.printStackTrace();	
			
			}
	 
			return driver;
	 
		}
		public static void implicitTime(int t,WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
			
		}
		public static boolean waitFor(int iSeconds) {
            try 
            {
                  Thread.sleep(iSeconds * 1000);
            } catch (Exception e) 
            {
                  System.out.println("Not able to Wait --- " + e.getMessage());
                  return false;
            }
            return true;
     
	}
	}