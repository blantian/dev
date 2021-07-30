package org.xtj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChapCount {
    //统计开始时间
    private String startTime;
    //统计结束时间
    private String endTime;
    //课程名
    private String courName;
    //课程次数
    private Long courNameNum;
    //章节id
    private Integer chapId;
    //章节名称
    private String chapName;
    //观看时间
    private Float pyTime;
    //老师id
    private Integer tcId;
    //老师姓名
    private String tcName;
    // 课程分类ID
    private Integer cateId ;
    // 课程分类名称
    private String  cateName ;
    // 课程归属省市区
    private String  coursePro ;
    // 课程归属市区
    private String courseCity ;
    // 课程归属区
    private String courseArea ;
    //统计时间
    private Long ts;

}
