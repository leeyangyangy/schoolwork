package xyz.leeyangy.utils;

import org.apache.ibatis.session.SqlSession;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;

import java.util.List;

/**
 * @author leeyangyang
 * @date 2022/9/20
 * @Description template class
 */
public class Template {
    public void Template() {
        //        获取SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            执行功能

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

}
