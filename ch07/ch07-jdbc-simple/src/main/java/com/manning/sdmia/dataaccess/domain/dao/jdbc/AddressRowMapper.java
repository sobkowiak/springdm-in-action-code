package com.manning.sdmia.dataaccess.domain.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manning.sdmia.dataaccess.domain.model.Address;
import com.manning.sdmia.dataaccess.domain.model.Contact;

public class AddressRowMapper implements RowMapper {
	private Contact contact;

	public AddressRowMapper(Contact contact) {
		this.contact = contact;
	}
	
	public Object mapRow(ResultSet rs, int i) throws SQLException {
		Address address= new Address();
		address.setId(rs.getInt("id"));
		address.setCity(rs.getString("city"));
		address.setContact(contact);
		return address;
	}

}
