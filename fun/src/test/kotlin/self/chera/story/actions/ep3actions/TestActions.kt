package self.chera.story.actions.ep3actions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import self.chera.story.actions.BaseTest

class TestActions : BaseTest() {
    init {
        web.get("https://keychera.github.io/")
    }

    fun testOnWeb() = Action(web)

    @Test fun `Verify the title`() {
        val web = testOnWeb()
        web.click(HomePage.link)
        web.getText(PostPage.title).let { title ->
            title shouldBe "Here is Chera"
        }
    }

    @Test fun `Verify the title v2`() {
        val web = testOnWeb()
        web.click(HomePage.link)
//        web.check(PostPage.title)
//            .whether(WebElement::getText)
//            .isEqualTo("Here is Chera")
    }
}

object HomePage {
    val link = By.className("post-link")
}

object PostPage {
    val title = By.className("post-title")
}

class Action(val web: WebDriver) {
    fun click(by: By) = web.findElement<WebElement>(by).click()
    fun getText(by: By) = web.findElement<WebElement>(by).text
}
