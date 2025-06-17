package my.thesis.dao

import my.thesis.dao.entity.LoanInfoEntity
import my.thesis.dao.mapper.toLoanInfoEntity
import my.thesis.model.rel.LoanInfoRel
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class LoanInfoDao(
    private val dslContext: DSLContext
) {

    fun get(id: UUID): LoanInfoEntity? {
        return dslContext.selectFrom(LoanInfoRel.instance)
            .where(LoanInfoRel.id.eq(id))
            .fetchOne {toLoanInfoEntity(it)}
    }
}