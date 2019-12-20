package com.briup.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.bean.Address;

public class AddressTypeHandler extends BaseTypeHandler<Address>{

	@Override
	public Address getNullableResult(ResultSet rs, String column) throws SQLException {
		// TODO Auto-generated method stub
		return new Address(rs.getString(column));
	}

	@Override
	public Address getNullableResult(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		return new Address(rs.getString(index));
	}

	@Override
	public Address getNullableResult(CallableStatement call, int index) throws SQLException {
		// TODO Auto-generated method stub
		return new Address(call.getString(index));
	}

	@Override
	public void setNonNullParameter(PreparedStatement pst, int index, Address addr, JdbcType arg3) throws SQLException {
		// TODO Auto-generated method stub
		pst.setString(index, addr.getAsString());
	}

}
