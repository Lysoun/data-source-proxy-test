import io.mockk.mockk
import org.example.DataSourceProxy
import org.example.ServiceToTest
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains

class ServiceToTestTest {
    private val dataSourceProxy = mockk<DataSourceProxy>()
    private val serviceToTest = ServiceToTest(
        dataSourceProxy
    )

    @Test
    fun myTest() {
        val id = "superb id"
        val name = serviceToTest.findDataSourceName(id)
        expectThat(name).contains(id)
    }
}