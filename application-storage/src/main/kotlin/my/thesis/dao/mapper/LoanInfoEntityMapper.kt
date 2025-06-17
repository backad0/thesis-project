package my.thesis.dao.mapper

import my.thesis.dao.entity.LoanInfoEntity
import my.thesis.model.rel.LoanInfoRel
import org.jooq.Record

fun toLoanInfoEntity(record: Record): LoanInfoEntity {
    return LoanInfoEntity(
        id = record[LoanInfoRel.id],
        amount = record[LoanInfoRel.amount],
        term = record[LoanInfoRel.term],
        interestRate = record[LoanInfoRel.interestRate]
    )
}