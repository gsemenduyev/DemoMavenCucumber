package com.practice;

import com.practice.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class MyTest {

    @Test
    public void multiple_window_test() throws InterruptedException {
        Thread.sleep(3000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://google.com");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://etsy.com/%27,%27_blank%27);%22");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://facebook.com/%27,%27_blank%27);%22");
    }
}
