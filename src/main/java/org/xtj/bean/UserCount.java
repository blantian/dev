package org.xtj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCount {
    //统计开始时间
    private String startTime;
    //统计结束时间
    private String endTime;
    //次数
    private Long userCount=0L;
    //时间戳
    private Long ts=0L;
    //播放时长
    private Float pt;
}
