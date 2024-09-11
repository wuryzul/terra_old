package io.wury.terra.curseforge.client

import jakarta.ws.rs.client.WebTarget
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class CurseForgeClient(
    @Qualifier("curseForgeRoot")
    private val root: WebTarget
) {

}