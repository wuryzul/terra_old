plugins {
  id("org.ajoberstar.reckon.settings") version "0.18.3"
}

reckon {
    setDefaultInferredScope("patch")
    stages("beta", "rc", "final")
    setScopeCalc(calcScopeFromProp().or(calcScopeFromCommitMessages()))
    setStageCalc(calcStageFromProp())
}

include("backend")
include("frontend")

rootProject.name = "terra"
