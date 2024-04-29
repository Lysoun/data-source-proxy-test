package org.example

class DataSourceProxy(
    override val core: DataSourceCoreService,
    override val blacklistPep: DataSourceBlacklistPepService,
    override val all: DataSourceAllService
): DataSourceProxyInterface {
    override fun of(id: String): DataSourceService {
        return if (id.contains("e")) {
            core
        } else {
            blacklistPep
        }
    }
}