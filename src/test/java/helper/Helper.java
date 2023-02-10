package helper;

import org.openqa.selenium.*;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Helper {

    public boolean elementExist(WebDriver driver, By by) {
        boolean elementExist = true;
        try {
            WebElement div = driver.findElement(by);
        } catch (NoSuchElementException error) {
            elementExist = false;
        }
        return elementExist;
    }

    public boolean elementExistByList(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public void downloadFile(String url, String filePath) {
        try {
            downloadUsingNIO(url, filePath);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }


    public int getHTTPResponseStatusCode(String urlP) throws IOException {
        try {
            URL url = new URL(urlP);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            return http.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshot(WebDriver driver, String pathNameWithFileName, String pictureExtension) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss").format(new Date());
        Files.copy(file.toPath(), new File(pathNameWithFileName + " - " + timestamp + pictureExtension).toPath());
    }
//    public void afterMethod(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String timestamp = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss").format(new Date());
//            Files.copy(file.toPath(), new File("screenshots/" + result.getName() +
//                    " - " + timestamp + ".png").toPath());
//        }
}
