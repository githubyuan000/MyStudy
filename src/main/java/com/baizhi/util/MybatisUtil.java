package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
		private static SqlSessionFactory factory = null;
		private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
		static{
			try {
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
				factory = builder.build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static SqlSession openSession(){
			SqlSession sqlSession = tol.get();
			if(sqlSession ==null){
				sqlSession  = factory.openSession();
				tol.set(sqlSession );
			}
			return sqlSession ;
		}
		
		public static void close(){
			SqlSession sqlSession 	= openSession();
			if(sqlSession !=null){
				try{
					sqlSession .close(); 
					tol.remove();
				}catch(Exception e){
					e.printStackTrace();
					}
				}
		}
		
		public static void commit(){
			SqlSession session = openSession();
			session.commit();
			close();
		}
		public static void rollback(){
			SqlSession session=openSession();
			session.rollback();
			close();
		}
		public static Object getMapper(Class a){
			SqlSession sqlSession  = openSession();
			return sqlSession.getMapper(a);
		}
}
