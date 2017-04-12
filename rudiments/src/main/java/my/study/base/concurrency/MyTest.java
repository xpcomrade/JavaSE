package my.study.base.concurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jesse
 * Date: 13-11-26
 * Time: 下午1:58
 * To change this template use File | Settings | File Templates.
 */
public class MyTest {

    public static void main(String[] args){
        Map<String, Integer> cakeMap = new HashMap<String,Integer>();

        cakeMap.put("1.2", 2);
        cakeMap.put("2.2",1);
        cakeMap.put("2.2",1);

        Map<String,Integer> cardMap = new HashMap<String, Integer>();

        cardMap.put("1.2",1);
        cardMap.put("2.2", 2);

        Iterator iter = cakeMap.entrySet().iterator();

        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iter.next();
            if (cardMap.containsKey(entry.getKey())) {
                if (entry.getValue().intValue() != cardMap.get(entry.getKey())){


                    System.out.println("你购买"+entry.getKey()+"磅蛋糕"+entry.getValue()+"个，但你录入了" +
                            cardMap.get(entry.getKey()) +"张" + entry.getKey()+"磅的积分卡");
                }

            }
        }


    }
    
}
