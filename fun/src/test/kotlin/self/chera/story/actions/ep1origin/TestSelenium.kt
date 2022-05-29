package self.chera.story.actions.ep1origin

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import self.chera.story.actions.BaseTest


class TestSelenium : BaseTest() {
    val link = By.className("post-link")

    init {
        web.get("https://keychera.github.io/")
    }

    @Test fun `Verify a click`() {
        web.findElement<WebElement>(link).click()
    }

    @Test fun `Verify a click implicitly`() {
        val wait = WebDriverWait(web, 15)
        wait.until(ExpectedConditions.visibilityOfElementLocated(link)).click()
    }
}