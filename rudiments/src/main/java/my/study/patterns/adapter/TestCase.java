package my.study.patterns.adapter;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TestCase {

    public static void main(String[] args) throws Exception{

        //通过反射可以灵活的更改适配器 (做到配置化）
        String adapterName = "OperationAdapter";
        Class c = Class.forName(adapterName);
        ScoreOperation operation = (ScoreOperation)c.newInstance();

        int[] scores = {84,76,50,69,90,91,88,96};

        System.out.println("成绩排序结果：");
        int[] sortedResult = operation.sort(scores);
        //遍历输出成绩
        for(int i : scores) {
            System.out.print(i + ",");
        }
        System.out.println();


        int score;
        System.out.println("查找成绩90：");
        score = operation.search(scores, 90);

        if (score != -1) {
            System.out.println("找到成绩90。");
        }
        else {
            System.out.println("没有找到成绩90。");
        }
    }
}
