package ufpe.mobggfl.Tables;

public class TableQueryAcessors {
    public static final String CREATE_USER_TABLE =
            "create table if not exists tb_user (" +
            "  uuid UUID primary key not null," +
            "  name text not null," +
            "  username text unique not null" +
            ");";

    public static final String USER_TABLE = "tb_user";


}
