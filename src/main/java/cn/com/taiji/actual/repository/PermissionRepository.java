package cn.com.taiji.actual.repository;

import cn.com.taiji.actual.domain.Permission;
import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zxx
 * @date 2018/12/14 11:39
 * @version 1.0
 */
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}
