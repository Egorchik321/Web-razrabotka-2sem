//Создайте программу, реализующую простую записную книжку с возможностями вводить, удалять, изменять контакты.
//Реализуйте главный класс MobilePhone, содержащий список контактов.
data class Contact(val name: String, val phoneNumber: String)

class MobilePhone {

    private val myContacts = ArrayList<Contact>()

    fun addNewContact(contact: Contact): Boolean {  //addNewContact () Добавляет новый контакт.
        if (findContact(contact) >= 0) {
            println("Контакт уже существует")
            return false
        }
        myContacts.add(contact)
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean { //updateContact () Изменяет существующий контакт.
        val position = findContact(oldContact)
        if (position < 0) {
            println("Контакт не найден")
            return false
        }
        val name = myContacts[position].name
        myContacts[position] = newContact
        println("Контакт $name изменен")
        return true
    }

    fun removeContact(contact: Contact): Boolean { //removeContact () Удаляет существующий контакт.
        val position = findContact(contact)
        if (position < 0) {
            println("Контакт не найден")
            return false
        }
        val name = myContacts[position].name
        myContacts.removeAt(position)
        println("Контакт $name успешно удален")
        return true
    }

    private fun findContact(contact: Contact): Int { //findContact () Ищет контакт.
        return myContacts.indexOf(contact)
    }

    fun queryContact(name: String): Contact? { //queryContact() Ищет контакт.
        for (i in myContacts.indices) {
            val contact = myContacts[i]
            if (contact.name == name) {
                println("Контакт $name найден:")
                println("${myContacts[i].name} -> ${myContacts[i].phoneNumber}")
                return contact
            }
        }
        println("Контакт $name не найден")
        return null
    }

    fun printContacts() { //printContacts() Вывод списка контактов типа Iterable.

        println("Список контактов:")
        for (i in myContacts.indices) {
            println("${i + 1}. ${myContacts[i].name} -> ${myContacts[i].phoneNumber}")
        }
    }
}

fun main() {
    val mobilePhone = MobilePhone()
    mobilePhone.addNewContact(Contact("Oleg", "8-800-555-35-35"))
    mobilePhone.addNewContact(Contact("Leonid", "8-999-999-99-99"))
    mobilePhone.printContacts()
    println()
    mobilePhone.updateContact(Contact("Oleg", "8-800-555-35-35"), Contact("Olegka", "8-888-888-88-88"))
    println()
    mobilePhone.printContacts()
    println()
    mobilePhone.removeContact(Contact("Leonid", "8-999-999-99-99"))
    println()
    mobilePhone.printContacts()
    println()
    mobilePhone.queryContact("Olegka")
}
