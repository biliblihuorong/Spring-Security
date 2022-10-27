package top.asshell.springsecurity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("user")
public class Users {
    private Integer id;
    private String userName;
    private String passwd;
}
