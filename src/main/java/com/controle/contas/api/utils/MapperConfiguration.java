package com.controle.contas.api.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class MapperConfiguration extends ModelMapper {	
	
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		ModelMapper modelMapper = new ModelMapper();		
		
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
}
