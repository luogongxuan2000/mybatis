import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 54110 on 2020/11/10.
 */
public class TestMyBatis {
    //查询所有
    @Test
    public void testMybatis() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用sqlSession对象加载你要执行的接口
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        List<User> all = userDao.findAll();
        //输出
        for (User user:all
             ) {
            System.out.println(user);
        }
    }
    //单个查询
    @Test
    public void testFindById() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User byId = mapper.findById(2);
        System.out.println(byId);
    }
    //id  name  查询
    @Test
    public void testfindByIdAndName() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //声明User对象
      /*  User user = new User();
        user.setUsername("千锋");
        user.setId(1);*/
        //声明map
        Map map = new HashMap();
        map.put("uid",2);
        map.put("teacherName","男");
        User byId = mapper.findByIdAndUserName(map);
        System.out.println(byId);
    }

    //模糊查询
    @Test
    public void testFindByNameLike() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> byId = mapper.findByNameLike("'%mm%'");
        for (User user:byId
             ) {
            System.out.println(user);
        }
    }
    //修改
    @Test
    public void testUpdate() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启状态  true
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setU_id(3);
        user.setU_name("小米");
        user.setU_pass("123");
        user.setU_email("123@123.com");
        user.setU_gender("男");
        int i = mapper.updateById(user);
        System.out.println("受影响的行数为==="+i);


    }
    //删除
    @Test
    public void testDelete() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.delById(2);
        System.out.println("受影响的行数为==="+i);
    }
    //增加
    @Test
    public void testInsert() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setU_gender("男");
        user.setU_email("456@456.com");
        user.setU_pass("456");
        user.setU_name("你好");
        int i = mapper.insertNew(user);
        System.out.println("受影响的行数为==="+i+"当前新增id为"+user.getU_id());


    }
}
