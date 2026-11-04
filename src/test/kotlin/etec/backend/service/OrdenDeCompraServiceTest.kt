package etec.backend.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

data class Item(val producto: String, val costo: Int);

class OrdenDeCompra() {
    private val items: MutableList<Item> = mutableListOf() //crea una lista mutable

    //creo una funcion que agrega por medio del metodo add un elemento nuevo a lista previamente creada
    fun agregarItem(producto: Item){
        items.add(producto)
    }

    fun calcularTotal(): Int {
        return items.sumOf { it.costo }
    }
}



class OrdenDeCompraServiceTest: BehaviorSpec ({
    Given("una orden de compra cuya suma de items resulta en 100 y el costo de la manteca es de 20") {
        val item = Item("Un producto", 100)
        val orden = OrdenDeCompra()
        orden.agregarItem(item)

        When("Agrego una manteca a la orden") {
            orden.agregarItem(Item("Manteca", 20))

            Then("La suma de mis items será de 120") {
                orden.calcularTotal() shouldBe 120
            }
        }
    }
})
