package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatisDemo{
        private static SqlSessionFactory factory = null;
        public static void main(String[] args) throws Throwable{
// TODO Auto-generated method stub
            factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-config.xml"));//配置工厂 读取config信息
            SqlSession session = factory.openSession();//获取一个工厂中的session 对数据库操作
            try{
                UserMapper userMapper = session.getMapper(UserMapper.class);//获取一个接口对象 使用的是sqlSession下面的类
//                System.out.println(userMapper.selectByPrimaryKey("zhang san"));
//                User user = new User("xiaoming","123","231","23@q.com");
                userMapper.deleteByPrimaryKey("xiaoming");
//                userMapper.insert(user);
//                System.out.println(userMapper.selectByPrimaryKey("xiaoming"));
                session.commit();//提交事务
            }finally{
                session.close();
            }
        }
}
