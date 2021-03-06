import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class SimpleGridTest {

    WebDriver driver;
    DesiredCapabilities capability = DesiredCapabilities.firefox();

    @Before
    public void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
    }

    @Test
    public void shouldGetGoogleTitle() {
        driver.get("http://www.google.pl");
        String title = driver.getTitle();
        assert (title.contains("Google"));

        driver.get("http://www.bol.com");
        title = driver.getTitle();
        assert (title.contains("bol.com"));

        driver.findElement(By.linkText("Boeken")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}