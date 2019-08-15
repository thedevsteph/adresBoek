package yass.stephanie.com.adresboek

import com.github.javafaker.Faker

class ResidentialDataRepository {

    companion object {
        var faker = Faker()
        private lateinit var database: ArrayList<Resident>

    }

    init {
        populateDatabase()
    }

    private fun createPerson(): Resident {

        val firstName: String? = faker.name().firstName()
        val lastName: String? = faker.name().lastName()
        val job: String? = faker.job().title()
        val address: String? = faker.address().fullAddress()
        val maritalStatus: String? = faker.demographic().maritalStatus()
        val educationalAttainment: String? = faker.demographic().educationalAttainment()

        return Resident(firstName, lastName, job, address, maritalStatus, educationalAttainment)
    }

    private fun populateDatabase(): ArrayList<Resident> {
        database = arrayListOf()
        for (i in 1..100) {
            var resident = createPerson()
            database.add(resident)
        }
        return database
    }

    fun getAllResidents(): ArrayList<Resident> {
        return database
    }


}