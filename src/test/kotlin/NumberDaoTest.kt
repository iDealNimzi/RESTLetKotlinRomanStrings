import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NumberDaoTest {
    private val numberDao = NumberDao()
    @Test
    //Logic testing that correct detects String and convert into number
    fun `logicalResponse should return 2006`() {
        val returnFromLogic = numberDao.logicalResponse("MMVI")
        assertEquals("2006", returnFromLogic)
    }

    @Test
    fun `romanString should be XX`() {
        val returnFromLogic = numberDao.romanString(20)
        assertEquals("XX", returnFromLogic)
    }

    @Test
    fun `regularNumber should be 20`() {
        val returnFromLogic = numberDao.regularNumber("XX")
        assertEquals("20", returnFromLogic)
    }
    // Adding more tests per Peer Review
    @Test
    fun `logicalResponse should return MMVI`() {
        val returnFromLogic = numberDao.logicalResponse("2006")
        assertEquals("MMVI", returnFromLogic)
    }
    @Test
    fun `romanString should return Blank String from null`() {
        val returnFromLogic = numberDao.romanString(null)
        assertEquals("", returnFromLogic)
    }

}