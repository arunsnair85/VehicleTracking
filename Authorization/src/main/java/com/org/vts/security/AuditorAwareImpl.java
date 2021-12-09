package com.org.vts.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

// TODO: Auto-generated Javadoc
/**
 * The Class AuditorAwareImpl.
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    /**
     * Gets the current auditor.
     *
     * @return the current auditor
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("SYSTEM_USER");
    }
}
