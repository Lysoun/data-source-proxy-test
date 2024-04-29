package org.example

class ServiceToTest(private val dataSourceProxy: DataSourceProxyInterface) {
    private val currentCompanyRef: String = "currentCompanyRef"

    fun findDataSourceName(id: String): String {
        return dataSourceProxy.of(id).findDataSource(id).name
    }

    fun findAllDataSourcesForCurrentCompany(): List<DataSource> {
        return dataSourceProxy.all.findAllDataSourcesForCompany(currentCompanyRef)
    }
}