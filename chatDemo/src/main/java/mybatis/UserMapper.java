package mybatis;

public interface UserMapper {
    int deleteByPrimaryKey(String username);
    int insert(User record);
    User selectByPrimaryKey(String username);
}
