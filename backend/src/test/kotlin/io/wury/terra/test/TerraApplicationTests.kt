package io.wury.terra.test

import io.wury.terra.TerraApp
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

@Import(TestContainersConfiguration::class)
@SpringBootTest
class TerraApplicationTests {
    @Test
    fun contextLoads() {

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