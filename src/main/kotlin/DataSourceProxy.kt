package org.example

class DataSourceProxy(
    val core: DataSourceCoreService,
    val blacklistPep: DataSourceBlacklistPepService,
    val all: DataSourceAllService
) {
    fun of(id: String): DataSourceService {
        return if (id.contains("e")) {
            core
        } else {
            blacklistPep
        }
    }
}