package org.example

open class DataSourceService {
    open fun findDataSource(id: String): DataSource {
        return DataSource(id, "companyRef")
    }

    open fun findAllDataSourcesForCompany(companyRef: String): List<DataSource> {
        return listOf(
            DataSource("dataSource1", companyRef),
            DataSource("dataSource2", companyRef)
        )
    }
}

class DataSourceCoreService: DataSourceService() {
    override fun findDataSource(id: String): DataSource {
        return DataSource("core $id", "coreCompanyRef")
    }
}

class DataSourceBlacklistPepService: DataSourceService() {
    override fun findDataSource(id: String): DataSource {
        return DataSource("blacklist pep $id", "blacklistPepCompanyRef")
    }
}

class DataSourceAllService: DataSourceService() {
    override fun findDataSource(id: String): DataSource {
        return DataSource("all $id", "companyRef")
    }
}