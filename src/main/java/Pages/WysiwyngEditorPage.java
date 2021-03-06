package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwyngEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[@aria-label='Increase indent']");

    public WysiwyngEditorPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToTheMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToTheMainArea();
    }

    public void increaseIndentation(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToTheMainArea();
        return text;
    }
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToTheMainArea(){
        driver.switchTo().parentFrame();
    }
}
