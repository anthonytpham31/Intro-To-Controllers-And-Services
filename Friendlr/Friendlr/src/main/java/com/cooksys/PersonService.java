package com.cooksys;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	private final PersonMapper personMapper;
	private AtomicLong idGenerator = new AtomicLong(0);
	private HashMap<Long, Person> idToPersonMap = new HashMap<>();
	
	public PersonService(PersonMapper personMapper) {
		super();
		this.personMapper = personMapper;
	}
	
	public Long add(Person person) {
		person.setId(idGenerator.incrementAndGet());
		idToPersonMap.put(person.getId(), person);
		return person.getId();
	}
	
	public boolean has(Long id) {
		return id != null && id > 0 && idToPersonMap.containsKey(id);
	}
	
	public PersonDto get(Long id) {
		return null;
	}
	
	public void put(Long id, Person person) {
		// TODO
	}
	
	public void delete(Long id) {
		idToPersonMap.remove(id);
	}

	public void post(Long id, Person person) {
		// TODO Auto-generated method stub
		
	}
}