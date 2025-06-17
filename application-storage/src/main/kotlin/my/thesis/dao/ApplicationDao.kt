package my.thesis.dao

import my.thesis.model.Application
import my.thesis.model.rel.ApplicationRel
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ApplicationDao(
    private val dslContext: DSLContext
) {

    fun getApplication(applicationId: UUID) : Application? {
        return dslContext
            .selectFrom(ApplicationRel.instance)
            .where(ApplicationRel.id.eq(applicationId))
            .fetchOne {
                Application(
                    it.get()
                )
            }
    }
}