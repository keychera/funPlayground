package self.chera.befun

import io.github.bonigarcia.wdm.WebDriverManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait


open class ATestMaster() {
    val globals = Globals("https://keychera.github.io/")
    lateinit var fixture: FixtureScope

    fun createTest(action: suspend FixtureScope.() -> Unit) {
        runBlocking {
            fixture = FixtureScope(this)
            action(fixture)
        }
    }

    @AfterEach fun close() {
        fixture.close()
    }
}


class ATestScript : ATestMaster() {

    @Test fun `Verify hello!`() = createTest {
        val job = launch {
            web.get(globals.url)
            WebDriverWait(web, 5)
                .until(visibilityOfElementLocated(By.id("")))
        }
        println("Hello!")
        job.join()
    }
}

class Globals(
    val url: String
)

class FixtureScope(
    originalScope: CoroutineScope
) : CoroutineScope by originalScope {
    val web: WebDriver

    init {
        WebDriverManager.chromedriver().setup()
        val opts = ChromeOptions().apply {
            addArguments("--incognito")
        }
        web = ChromeDriver(opts)
    }

    fun close() {
        web.quit()
    }
}