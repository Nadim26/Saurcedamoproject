package datadrivertest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium. TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

       private static String fileNameGenerate() {
          LocalDateTime now = LocalDateTime.now();
          String fileName = now.toString();
          fileName = fileName.replace(":", "").replace(".", "-");
          return fileName;
       }

      public static void main(String[] args) {
          fileNameGenerate();
      }
      public static void takeScreenShot (WebDriver driver) {
      File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);
      try {
          FileUtils.copyFile(screenShotFile, new File("./photo/"+fileNameGenerate()+".jpg"));
      } catch (IOException e) {
	e.printStackTrace();
      }

   }

}
