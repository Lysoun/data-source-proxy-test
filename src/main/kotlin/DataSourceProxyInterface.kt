package org.example

interface DataSourceProxyInterface {
    val core: DataSourceCoreService
    val blacklistPep: DataSourceBlacklistPepService
    val all: DataSourceAllService

    fun of(id: String): DataSourceService
}