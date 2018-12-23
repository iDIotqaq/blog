package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户相关操作的Service
 * @author zxx
 * @version 1.0
 * @date 2018/12/14 16:40
 */
public interface UserInfoService {

    /**
     * 根据id查询单个
     * @param id id
     * @return 用户实体
     */
    UserInfo findById(Integer id);

    /**
     * 根据用户名查询单个
     * @param username 用户名
     * @return 用户实体
     */
    UserInfo findByUsername(String username);
    /**
     * 查询所有用户
     * @return 用户实体List
     */
    List<UserInfo> findAll();

    /**
     * 分页显示用户
     * @param page 页数
     * @return 存有分页信息和查出数据的map
     */
    Map findPagination(Integer page);

    /**
     * 删除用户
     * @param id id
     */

    void deleteById(Integer id);

    /**
     * 新增用户
     * @param userInfo 用户实体
     */
    void addUser(UserInfo userInfo);

    /**
     * 更新用户
     * @param userInfo 用户实体
     */
    void updateUser(UserInfo userInfo);

    /**
     * 更新用户角色
     * @param userInfo 用户实体
     */
    void updateUserRole(UserInfo userInfo);

}
