package my.thesis.model.rel

import org.jooq.Record
import org.jooq.TableField
import org.jooq.impl.DSL.name
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import java.math.BigDecimal
import java.util.UUID

class LoanInfoRel : TableImpl<Record>(
    name("loan_info")
) {
    companion object {
        val instance: LoanInfoRel = LoanInfoRel()

        val id: TableField<Record, UUID> = createField(
            name("id"),
            SQLDataType.UUID.nullable(false),
            instance
        )
        val amount: TableField<Record, BigDecimal> = createField(
            name("amount"),
            SQLDataType.NUMERIC.nullable(false),
            instance
        )

        val term: TableField<Record, Int> = createField(
            name("term"),
            SQLDataType.INTEGER.nullable(false),
            instance
        )

        val interestRate: TableField<Record, BigDecimal> = createField(
            name("interest_rate"),
            SQLDataType.NUMERIC.nullable(false),
            instance
        )
    }
}