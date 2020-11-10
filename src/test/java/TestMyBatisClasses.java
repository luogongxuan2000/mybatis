import com.qf.dao.ClassesDao;
import com.qf.dao.UserDao;
import com.qf.pojo.Classes;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatisClasses {
    @Test
    public void testFindAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesDao mapper = sqlSession.getMapper(ClassesDao.class);
        List<Classes> all = mapper.findAll();
        for (Classes classes:all
             ) {
            System.out.println(classes);
        }
    }


    @Test
    public void testFindById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesDao mapper = sqlSession.getMapper(ClassesDao.class);
        User byId = mapper.findById(3);
        System.out.println(byId);
    }

    @Test
    public void testfindByName() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesDao mapper = sqlSession.getMapper(ClassesDao.class);
        User res = mapper.findByName("你好");
        System.out.println(res);
    }
}
