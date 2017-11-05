package controller

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object ModuleControllerSpec : Spek(
        {
            describe("module controller")
            {
                val controller = ModuleController

                on("register")
                {
                    it("should have an amount of 1")
                    {
                    }

                    it("should have the correct vendor field")
                    {
                    }
                }

                on("get passphrase")
                {
                    it("should have an amount of 1")
                    {
                    }

                    it("should have the correct vendor field")
                    {
                    }
                }
            }
        })
