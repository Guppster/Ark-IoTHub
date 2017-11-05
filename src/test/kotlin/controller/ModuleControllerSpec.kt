package controller

import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.json.JSONObject

object ModuleControllerSpec : Spek(
        {
            describe("module controller")
            {
                val testAddressInvalid = "AZeoyzei9CwqAksMzngX2NBNSTgzxfNLFG"
                val testAddressValid = "AZeoyzei9CwqAksMzngX2NBNSTgzxfNLFG"
                val controller = ModuleController()

                on("register")
                {
                    it("should add an element to modules list on valid address")
                    {
                        //TODO("Can't test valid address until a module is on MainNet." +
                        //       "or need to fake one on DevNet")
                    }

                    it("should not add an element to modules list on invalid address")
                    {
                        controller.registerModule(testAddressInvalid)

                        assert.that(controller.getModules().size, equalTo(0))
                    }
                }

                on("get transaction") {

                    var transactions = controller.getTransactions(testAddressInvalid)

                    it("should return non-null json object")
                    {
                        assert.that(transactions, has(JSONObject::length, greaterThan(0)))
                    }

                    it("should have the correct count")
                    {
                        assert.that(transactions.getInt("count"), equalTo(2))
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
