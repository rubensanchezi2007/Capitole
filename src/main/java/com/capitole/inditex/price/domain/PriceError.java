package com.capitole.inditex.price.domain;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderClassName = "Builder", toBuilder = true)
public class PriceError {

    public static final PriceError ERROR_PRICE_NOT_FOUND =
            of(100,"Price not found");

    public static final PriceError ERROR_GATEWAY_PRICE_SERVICE=
            of(101,"Price Gateway Price service");


    private final int errorCode;
    private final String errorMessage;


    public static PriceError of (int errorCode, String errorMessage)
    {
        return new PriceError(errorCode,errorMessage);
    }

    @JsonPOJOBuilder(withPrefix="")
    public static class Builder {}


}
