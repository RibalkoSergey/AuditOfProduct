package com.aop.config.hibernate;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.type.StringType;

import java.sql.Types;

public class OracleDialect extends Oracle10gDialect {

    public OracleDialect() {
        super();
    }

    @Override
    protected void registerReverseHibernateTypeMappings() {
        super.registerReverseHibernateTypeMappings();
        registerHibernateType(Types.NVARCHAR, StringType.INSTANCE.getName());
    }
}
