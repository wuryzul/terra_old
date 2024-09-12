package io.wury.terra.test

import io.wury.terra.TerraApp
import io.wury.terra.curseforge.client.ModClient
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
        val mod = modClient.getMod(306935).block()
        assertNotNull(mod)
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