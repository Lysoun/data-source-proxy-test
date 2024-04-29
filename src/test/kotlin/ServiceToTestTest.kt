import io.mockk.every
import org.example.DataSource
import org.example.DataSourceService
import org.example.ServiceToTest
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains

class ServiceToTestTest {
    private val dataSourceProxy = DataSourceProxyFake()
    private val serviceToTest = ServiceToTest(
        dataSourceProxy
    )

    @Test
    fun myTest() {
        val id = "superb id"
        dataSourceProxy.withFindDataSourceMocked { dataSourceService: DataSourceService ->
            every { dataSourceService.findDataSource(eq(id)) } returns DataSource(id)
        }
        val name = serviceToTest.findDataSourceName(id)
        expectThat(name).contains(id)
    }
}