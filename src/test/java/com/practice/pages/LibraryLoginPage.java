package com.practice.pages;

import com.practice.utilities.ConfigurationReader;
import com.practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
  public   LibraryLoginPage(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signIn;

    /*
    Login method that logs in with specific username
     */

    public void login(){
      emailInput.sendKeys("username");
      passwordInput.sendKeys("password");
      signIn.click();
    }


    /*
    Login with admin
     */
    public void loginWithAdmin() {
      emailInput.sendKeys("username");
      passwordInput.sendKeys("password");
      signIn.click();
    }
    public void loginWithConfig() {
      emailInput.sendKeys(ConfigurationReader.getProperty("username"));
      passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
      signIn.click();

    }

    public void login(String username, String password){
      emailInput.sendKeys(username);
      passwordInput.sendKeys(password);
      signIn.click();
    }


}
