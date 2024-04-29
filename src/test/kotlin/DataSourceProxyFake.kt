import io.mockk.MockKAdditionalAnswerScope
import io.mockk.every
import io.mockk.mockk
import org.example.*

class DataSourceProxyFake(
    override val core: DataSourceCoreService = mockk<DataSourceCoreService>(),
    override val blacklistPep: DataSourceBlacklistPepService = mockk<DataSourceBlacklistPepService>(),
    override val all: DataSourceAllService = mockk<DataSourceAllService>(),
) : DataSourceProxyInterface {
    fun withFindDataSourceMocked(mockMethod: (DataSourceService) -> MockKAdditionalAnswerScope<DataSource, DataSource>) {
        mockMethod(core)
        mockMethod(blacklistPep)
        mockMethod(all)
    }

    override fun of(id: String): DataSourceService {
        return core
    }
}