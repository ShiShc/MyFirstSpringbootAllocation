package icu.shishc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @date:2021/4/10, 15:21
 * @author:ShiShc
 */

@Entity
@Data
public class SysRole {
    @Id@GeneratedValue
    private Integer id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;


    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;

    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<UserInfo> userInfos;

}
