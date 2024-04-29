package org.example

open class DataSourceService {
    open fun findDataSource(id: String): DataSource {
        return DataSource(id)
    }
}

class DataSourceCoreService: DataSourceService() {
    override fun findDataSource(id: String): DataSource {
        return DataSource("core $id")
    }
}

class DataSourceBlacklistPepService: DataSourceService() {
    override fun findDataSource(id: String): DataSource {
        return DataSource("blacklist pep $id")
    }
}

class DataSourceAllService: DataSourceService() {
    override fun findDataSource(id: String): DataSource {
        return DataSource("all $id")
    }
}