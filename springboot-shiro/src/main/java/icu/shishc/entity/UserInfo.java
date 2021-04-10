package icu.shishc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @date:2021/4/10, 15:19
 * @author:ShiShc
 */

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique =true)
    private String username;
    private String name;
    private String password;
    private String salt;
    private byte state;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;
}
