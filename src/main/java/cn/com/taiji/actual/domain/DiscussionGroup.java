package cn.com.taiji.actual.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/14 16:28
 */
//@Entity
@Data
public class DiscussionGroup {
    @Id
    @GeneratedValue
    private Integer did;

    private String discussionName;

    private UserInfo leader;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DiscussionUser",
            joinColumns = {@JoinColumn(name = "did")},inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> users;

    private String createDate;

    private Integer state;
}
