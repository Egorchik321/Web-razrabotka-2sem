//Самостоятельно создать класс для сериализации  и десериализации json. После создания класса создать тесты и с помощью них провести проверку на сериализацию и десериализацию. Для это лучше использовать gradle проект.
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class Product(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("count") val count: Int,
    @SerializedName("price") val price: Int,
)

class JsonConverter {
    private val gson = Gson()
    fun toJson(person: Product): String {
        return gson.toJson(person)
    }

    fun fromJson(json: String): Product {
        return gson.fromJson(json, Product::class.java)
    }
}

class PersonTest {
    private val js= JsonConverter()

    @Test
    fun serializePerson() {
        val person = Product("Фильтр", "Угольный", 25, 3000)
        val json = js.toJson(person)
        assertEquals("""{"name":"Фильтр","description":"Угольный","count":25,"price":3000}""", json)

        println("Cериализация: \nВходные данные: $person \nВыходные данные: $json")
        println()
    }

    @Test
    fun deserializePerson() {
        val json = """{"name":"Суппорт","description":"Тормозной","count":30,"price":2500}"""
        val person = js.fromJson(json)
        assertEquals(Product("Суппорт", "Тормозной",30, 2500), person)

        println("Десериализация: \nВходные данные: $json \nВыходные данные: $person")
        println()
    }
}