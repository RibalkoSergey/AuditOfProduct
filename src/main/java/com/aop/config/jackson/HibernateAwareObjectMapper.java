package com.aop.config.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
        configure(DeserializationFeature.EAGER_DESERIALIZER_FETCH, true);
        configure(SerializationFeature.EAGER_SERIALIZER_FETCH, true);
    }
}
