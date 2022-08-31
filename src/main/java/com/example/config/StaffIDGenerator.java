package com.example.config;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StaffIDGenerator implements IdentifierGenerator {
	private final String prefix = "NV";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String query = "select s.nvId from Staff s";
		Stream<String> ids = session.createQuery(query, String.class).stream();
		
		Integer max = ids.map(id -> id.replace(prefix, "")).mapToInt(Integer::parseInt).max().orElse(0);
		
		return prefix + String.format("%05d", max + 1);
	}
}
