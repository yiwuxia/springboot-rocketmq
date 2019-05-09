package com.example.demo.core;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.example.demo.domin.MyType;
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = MyType.class)
public class EnumValueTypeHandler  extends BaseTypeHandler<EnumBehaviour>{
	
	private Class<EnumBehaviour> type;
    private final EnumBehaviour[] enums;
	
	  public EnumValueTypeHandler(Class<EnumBehaviour> type) {
	        if (type == null)
	            throw new IllegalArgumentException("Type argument cannot be null");
	        this.type = type;
	        this.enums = type.getEnumConstants();
	        if (this.enums == null)
	            throw new IllegalArgumentException(type.getSimpleName()
	                    + " does not represent an enum type.");
	    }

	  @Override
	    public EnumBehaviour getNullableResult(ResultSet rs, String columnName) throws SQLException {
	        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
	        int i = rs.getInt(columnName);
	        if (rs.wasNull()) {
	            return null;
	        } else {
	            // 根据数据库中的code值，定位EnumBehaviour子类
	            return locateEnumBehaviour(i);
	        }
	    }
	  
	  @Override
	    public EnumBehaviour getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
	        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
	        int i = rs.getInt(columnIndex);
	        if (rs.wasNull()) {
	            return null;
	        } else {
	            // 根据数据库中的code值，定位EnumBehaviour子类
	            return locateEnumBehaviour(i);
	        }
	    }
	  
	    @Override
	    public EnumBehaviour getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
	        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
	        int i = cs.getInt(columnIndex);
	        if (cs.wasNull()) {
	            return null;
	        } else {
	            // 根据数据库中的code值，定位EnumBehaviour子类
	            return locateEnumBehaviour(i);
	        }
	    }

	    @Override
	    public void setNonNullParameter(PreparedStatement ps, int i, EnumBehaviour parameter, JdbcType jdbcType)
	            throws SQLException {
	        // baseTypeHandler已经帮我们做了parameter的null判断
	        ps.setInt(i, parameter.getCode());
	    }
	    
	    private EnumBehaviour locateEnumBehaviour(int code) {
	        for (EnumBehaviour status : enums) {
	            if (status.getCode() == code) {
	                return status;
	            }
	        }
	        throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + type.getSimpleName());
	    }

	    
	    
}
