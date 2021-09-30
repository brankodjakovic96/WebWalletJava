package com.webwallet.core.domain.valueObjects.converters;

import com.webwallet.core.domain.valueObjects.Jmbg;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class JmbgAttributeConverter implements AttributeConverter<Jmbg, String> {
    @Override
    public String convertToDatabaseColumn(Jmbg jmbg) {
        return jmbg == null ? null : jmbg.toString();
    }

    @Override
    public Jmbg convertToEntityAttribute(String s) {
        return s == null ? null : new Jmbg(s); // <4>
    }
}
