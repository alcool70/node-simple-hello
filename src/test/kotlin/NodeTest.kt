import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class NodeTest {

    companion object {
        @BeforeAll @JvmStatic
        fun setupClass() {
            WebDriverManager.chromedriver().setup()
        }
    }

    private var driver: WebDriver? = null

    @BeforeEach
    fun setupTest() {
        val options = ChromeOptions()
        if (System.getProperties().containsKey("headless"))
            options.addArguments("--headless")
        driver = ChromeDriver(options)
    }

    @Test
    fun test() {
        driver?.get("http://localhost:10000/")
        val el = driver?.findElement(By.xpath("//*[text()='How about a nice ordered list!']"))
        assertTrue(el != null)
    }

    @AfterEach
    fun teardown() {
        driver?.quit()
    }
}
