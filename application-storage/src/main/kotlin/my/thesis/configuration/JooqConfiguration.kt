package my.thesis.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.internal.jdbc.DriverDataSource
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class JooqConfiguration {

    @Bean
    fun dataSource(
        @Value("\${spring.datasource.url}") uri: String,
        @Value("\${spring.datasource.username}") username: String,
        @Value("\${spring.datasource.password}") password: String,
        @Value("\${spring.datasource.driver-class-name}") driverClassName: String,
    ): DataSource {
        val config = HikariConfig()
        config.jdbcUrl = uri
        config.password = password
        config.username = username
        config.driverClassName = driverClassName

        return HikariDataSource(config)
    }

    @Bean
    fun transactionManager(
        dataSource: DataSource
    ) : PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    @Bean
    fun dsl(dataSource: DataSource): DSLContext {
        return DSL.using(dataSource, SQLDialect.POSTGRES)
    }
}