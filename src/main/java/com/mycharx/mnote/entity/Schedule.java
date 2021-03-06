package com.mycharx.mnote.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * 日程实体类
 *
 * @author 张卜亢
 * @date 2018.09.03 14:49:16
 */
@Getter
@Setter
@Entity
public class Schedule {
    /**
     * 日程ID，数据库自增生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 父日程ID
     */
    private Long pid;
    /**
     * 该日程的子集日程列表
     */
    @OneToMany(targetEntity = Schedule.class,
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "pid")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("updateTime desc")
    private Set<Schedule> chilSchedules;
    /**
     * 日程标题
     */
    @Column(length = 300)
    private String title;
    /**
     * 日程内容
     */
    @Column(length = 3000)
    private String text;
    /**
     * 日程优先级
     * 0高，1中，2低
     */
    private Integer priority;
    /**
     * 日程状态
     * -1结束，1开始(进行中)，0挂起
     */
    private Integer status;
    /**
     * 最后修改时间，时间戳
     */
    private Long updateTime;
}
