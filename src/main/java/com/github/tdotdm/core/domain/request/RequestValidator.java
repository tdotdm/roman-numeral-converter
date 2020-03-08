package com.github.tdotdm.core.domain.request;

import com.github.tdotdm.core.configuration.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RequestValidator {
    private final int lowerBound;
    private final int upperBound;

    public RequestValidator(final ApplicationProperties applicationProperties) {
        this.lowerBound = applicationProperties.getLowerBound();
        this.upperBound = applicationProperties.getUpperBound();
    }

    /*
     * Validate the User's input against the
     * configured lower and upper bound. If the
     * User's input is outwith the boundary range,
     * then the number is not valid.
     * */
    public boolean validate(final int numberToConvert) {
        if (numberToConvert == 0) {
            return false;
        }

        return numberToConvert >= lowerBound && numberToConvert <= upperBound;
    }
}
