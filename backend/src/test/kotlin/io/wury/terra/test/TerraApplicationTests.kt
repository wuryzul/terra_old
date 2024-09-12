package io.wury.terra.test

import io.wury.terra.TerraApp
import io.wury.terra.curseforge.client.ModClient
import io.wury.terra.curseforge.representation.request.SearchModsRequest
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
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
            val mod = modClient.getMod(306935).awaitSingleOrNull()
            assertNotNull(mod)
        }
    }

    @Test
    fun testSearchMod() {
        runBlocking {
            val mod = modClient.searchMods(SearchModsRequest(slug = "jei")).awaitSingleOrNull()
            assertNotNull(mod)
        }
    }

    @Test
    fun createApplicationModuleModel() {
        val modules = ApplicationModules.of(TerraApp::class.java)
        modules.forEach(::println)
    }

    fun createModuleDocumentation() {
        val modules = ApplicationModules.of(TerraApp::class.java)
        Documenter(modules).writeDocumentation().writeIndividualModulesAsPlantUml()
    }
}