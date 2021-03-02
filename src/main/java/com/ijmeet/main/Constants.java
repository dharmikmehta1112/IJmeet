package com.ijmeet.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.imageio.stream.ImageOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Constants {
	
	public static WebDriver driver;
	public static WebElement element;
	public static String basePath = System.getProperty("user.dir");
	public static WebDriverWait wait;
	public static FileInputStream fis;	
	public static Properties prop;
	public static AShot ashot;
	public static File file;
	public static Screenshot screenShot;
	public static BufferedImage bufferImg;
	public static Actions actions;
	public static Select select;
	public static Boolean flag;
	public static String expected;
	public static String actual;
	public static final int WebDriverWaitTimeOutInSec = 10;
	public static final int WebDriverWaitSleepInMilli = 200;
	


}
