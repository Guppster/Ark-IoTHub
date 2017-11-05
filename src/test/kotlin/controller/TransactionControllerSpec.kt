package controller

import com.natpryce.hamkrest.assertion.*
import com.natpryce.hamkrest.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


object TransactionControllerSpec : Spek(
{
    describe("transaction controller")
    {
        val controller = TransactionController(ModuleController)

        on("construct message")
        {
            val moduleAddress = "TestModuleAddress"
            val recipientAddress = "TestRecipientAddress"
            val vendorField = "TestVendorField"

            var transaction = controller.constructMessage(moduleAddress, recipientAddress, vendorField)

                    //amount should be one
                    //vendor field should be correctly assigned
                    //recipient address is correct
                    //sender address is correct
                    //it is signed or w/e indicates its correct (signSigniture != null)

            it("should have an amount of 1")
            {
                assert.that(transaction.amount, equalTo(1L))
            }

            it("should have the correct vendor field")
            {
                assert.that(transaction.vendorField, equalTo(vendorField))
            }


        }
    }
})

