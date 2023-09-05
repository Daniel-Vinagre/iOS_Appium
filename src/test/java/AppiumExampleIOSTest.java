import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AppiumExampleIOSTest {

    public IOSDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("platformName", "iOS");
        options.setPlatformVersion("16.4");
        options.setCapability("automationName ", "XCUITest");
        options.setDeviceName("iPhone 14 Pro Max");
        options.setCapability("udid", "F8D1CE86-7661-47A5-8E8E-8C7EB4849282");
        options.setCapability("autoAcceptAlerts" ,true);

        //Descomenta una de las siguientes capabilities para ejecutar la app
        //options.setApp("Ruta_al_.app");
        options.setBundleId("com.cepsa.xmartplace");

        driver = new IOSDriver(new URL("http://localhost:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ejemploTest() {
        driver.findElement(AppiumBy.accessibilityId("Permitir una vez")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Saltar\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Crear cuenta\"`]")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"))
                .sendKeys("Mr");
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"))
                .sendKeys("Cepsa");
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"))
                .sendKeys("Cepsa@cepsa.cepsa");
        driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeSecureTextField\""))
                .sendKeys("Cepsa11223344");
        driver.findElement(AppiumBy.accessibilityId("Done")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Registrar\"`]")).click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}