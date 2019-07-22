import indi.tony.yrtester.util.DBUtil;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
//        ArrayList<String> tables = new ArrayList<String>();
//        DBUtil.initDB();
//        ArrayList<String> sqllist = new ArrayList<String>();
//        sqllist.add("insert into testcase values(1,'156546', 'xxx')");
//        DBUtil.insertContent(sqllist);
        System.out.println(DBUtil.selectContentMap("select * from test_steps"));
    }
}
