package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author zxx
 * @date 2018/12/14 10:52
 * @version 1.0
 */
@Entity
@Table(name = "sys_user")
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer uid;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private String createDate;

    private Integer state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<Role> roles;

}
