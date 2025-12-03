package com.studentportal.commons;

import org.modelmapper.ModelMapper;

import java.util.List;

public class DtoMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <S, D> D map(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    public static <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationClass) {
        return sourceList.stream()
                .map(element -> modelMapper.map(element, destinationClass))
                .toList();
    }
}
