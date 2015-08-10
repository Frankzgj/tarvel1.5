package com.lonton.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lonton.mapper.ITripMapper;

public class DatabaseService {

	//定义对象
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	
	//静态快
	static{
		try {
			reader = Resources.getResourceAsReader("mybatis/db.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (IOException e) {
		
		}finally{
        	if(reader != null)
        	{
        		try {
					reader.close();
				} catch (IOException e) {
					
				}
        	}
        }
		
	}
	
	/**
	 * 数据库工厂
	 */
	public ITripMapper databaseService()
	{
		
		SqlSession session = sqlSessionFactory.openSession();
		//将从数据库取得的数据实例化
		ITripMapper userOperation = session.getMapper(ITripMapper.class);
		return userOperation;
	}
}
