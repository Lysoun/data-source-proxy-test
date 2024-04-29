import io.mockk.every
import org.example.DataSource
import org.example.DataSourceService
import org.example.ServiceToTest
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.hasSize

class ServiceToTestTest {
    private val dataSourceProxy = DataSourceProxyFake()
    private val serviceToTest = ServiceToTest(
        dataSourceProxy
    )

    @Test
    fun myTest() {
        val id = "superb id"
        dataSourceProxy.mockAllServicesWith { dataSourceService: DataSourceService ->
            every { dataSourceService.findDataSource(eq(id)) } returns DataSource(id, "companyRef")
        }
        val name = serviceToTest.findDataSourceName(id)
        expectThat(name).contains(id)
    }

    @Test
    fun `find all data source should return 2 data sources`() {
        dataSourceProxy.mockAllServicesWith {
            every { it.findAllDataSourcesForCompany(any()) } returns listOf(
                DataSource("", ""),
                DataSource("", "")
            )
        }

        val dataSources = serviceToTest.findAllDataSourcesForCurrentCompany()
        expectThat(dataSources).hasSize(2)
    }
}