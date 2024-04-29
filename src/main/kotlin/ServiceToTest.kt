package org.example

class ServiceToTest(private val dataSourceProxy: DataSourceProxy) {
    fun findDataSourceName(id: String): String {
        return dataSourceProxy.of(id).findDataSource(id).name
    }
}