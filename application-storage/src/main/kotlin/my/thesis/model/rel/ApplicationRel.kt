package my.thesis.model.rel

import org.jooq.Record
import org.jooq.TableField
import org.jooq.impl.DSL.name
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import java.util.UUID

class ApplicationRel private constructor() : TableImpl<Record>(name("application")) {

    companion object {
        val instance: ApplicationRel = ApplicationRel()

        val application: TableField<Record, String> = createField(
            name("application"),
            SQLDataType.VARCHAR,
            instance
        )
        val id: TableField<Record, UUID> = createField(
            name("application"),
            SQLDataType.UUID,
            instance
        )
    }
}