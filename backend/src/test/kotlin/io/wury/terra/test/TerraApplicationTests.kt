package io.wury.terra.test

import io.wury.terra.curseforge.client.ModClient
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import kotlin.test.assertNotNull

@Import(TestContainersConfiguration::class)
@SpringBootTest
class TerraApplicationTests(
    @Autowired
    private val modClient: ModClient,
) {
    @Test
    fun contextLoads() {

    }

    @Test
    fun testGetMod() {
        runBlocking {
            val mod = modClient.getMod(306935)
            assertNotNull(mod)
        }
    }

    @Test
    fun testSearchMod() {
        runBlocking {
            val mod = modClient.searchMods(SearchModsRequest(slug = "jei"))
            assertNotNull(mod)
        }
    }
}