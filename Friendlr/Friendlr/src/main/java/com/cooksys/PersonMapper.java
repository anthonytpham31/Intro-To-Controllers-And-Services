package com.cooksys;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
	
	@Mappings({
		@Mapping(target = "friendsId")
	})
	PersonDto personToPersonDto(Person friends);
	 
	default List<Long> friendsToFriendsDto(List<Person> persons) {
		List<Long> convertedList = new ArrayList<>();
			for (Person personId : persons) {
				convertedList.add(personId.getId());
			}
		return convertedList;
	}
	
	@Mappings({
		@Mapping(target = "friendsId")
	})
	Person personDtoToPerson(PersonDto friends);
	
	default List<Person> friendsDtoToFriends(List<Long> ids) {
		List<Person> convertedList = new ArrayList<>();
		for (Long id : ids) {
			Person convertedPerson = new Person();
			convertedPerson.setId(id);
			convertedList.add(convertedPerson);
		}
		return convertedList;
	}
}
