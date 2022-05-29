package self.chera.story.actions

import org.junit.jupiter.api.AfterEach
import self.chera.befun.ChromeScope
import self.chera.befun.WebDriverScope

open class BaseTest : WebDriverScope by ChromeScope() {
    @AfterEach fun closeDriver() = web.close()
}