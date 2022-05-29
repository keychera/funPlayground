package self.chera.story.actions.ep2POM

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import self.chera.story.actions.BaseTest

class TestPageObjectModel : BaseTest() {
    init {
        web.get("https://keychera.github.io/")
    }

    @Test fun `Verify the title`() {
        HomePage(web).clickLink().getTitle().let { title ->
            title shouldBe "Here is Chera"
        }
    }
}

class HomePage(val web: WebDriver) {
    val link = By.className("post-link")

    fun clickLink(): PostPage {
        web.findElement<WebElement>(link).click()
        return PostPage(web)
    }
}

class PostPage(val web: WebDriver) {
    val title = By.className("post-title")

    fun getTitle() = web.findElement<WebElement>(title).text
}