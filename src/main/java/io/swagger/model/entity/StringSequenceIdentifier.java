package io.swagger.model.entity;

import io.swagger.repository.AccountRepository;
import io.swagger.repository.RoleRepository;
import io.swagger.repository.UserRepository;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.Serializable;
import java.util.Properties;
import java.util.Random;

@Component
@EnableTransactionManagement
public class StringSequenceIdentifier implements
        IdentifierGenerator, Configurable {

    public static final String SEQUENCE_PREFIX = "sequence_prefix";

    private String sequencePrefix;

    private String sequenceCallSyntax;

    @Override
    public void configure(
            Type type,
            Properties params,
            ServiceRegistry serviceRegistry)
            throws MappingException {

        final JdbcEnvironment jdbcEnvironment = serviceRegistry
                .getService(
                        JdbcEnvironment.class
                );

        final Dialect dialect = jdbcEnvironment.getDialect();

        final ConfigurationService configurationService = serviceRegistry
                .getService(
                        ConfigurationService.class
                );

        String globalEntityIdentifierPrefix = configurationService
                .getSetting(
                        "entity.identifier.prefix",
                        String.class,
                        "SEQ_"
                );

        sequencePrefix = ConfigurationHelper
                .getString(
                        SEQUENCE_PREFIX,
                        params,
                        globalEntityIdentifierPrefix
                );

        final String sequencePerEntitySuffix = ConfigurationHelper
                .getString(
                        SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                        params,
                        SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX
                );

        boolean preferSequencePerEntity = ConfigurationHelper
                .getBoolean(
                        SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
                        params,
                        false
                );

        final String defaultSequenceName = preferSequencePerEntity
                ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
                : SequenceStyleGenerator.DEF_SEQUENCE_NAME;

        sequenceCallSyntax = dialect
                .getSequenceNextValString(
                        ConfigurationHelper.getString(
                                SequenceStyleGenerator.SEQUENCE_PARAM,
                                params,
                                defaultSequenceName
                        )
                );
    }

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session,
            Object obj) {

        long seqValue = ((Number)
                Session.class.cast(session)
                        .createNativeQuery(sequenceCallSyntax)
                        .uniqueResult()
        ).longValue();

        StringBuilder iban = new StringBuilder(sequencePrefix + "SWAG");
        iban.append(String.format("%09d%s", 0, seqValue));

        return iban.toString();
    }
}