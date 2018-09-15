package com.mycharx.mnote.controller;

import com.mycharx.mnote.entity.Schedule;
import com.mycharx.mnote.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The type Schedule controller.
 *
 * @author 张卜亢
 * @date 2018.09.03 21:49:11
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    Logger logger = LoggerFactory.getLogger(ScheduleController.class);
    /**
     * The Schedule service.
     */
    @Resource
    private ScheduleService scheduleService;

    /**
     * Save or update schedule schedule.
     *
     * @param schedule the schedule
     * @return the schedule
     */
    @PostMapping("/saveOrUpdate")
    public Schedule saveOrUpdateSchedule(Schedule schedule) {
        return scheduleService.saveOrUpdateSchedule(schedule);
    }


    /**
     * Find page schedule page.
     *
     * @param pageable the pageable，默认第一页，每页30条
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:28:32
     */
    @GetMapping("/findPageSchedule")
    public Page<Schedule> findPageSchedule(@PageableDefault(size = 30) Pageable pageable) {
        return scheduleService.findPageSechedule(pageable);
    }

    /**
     * Find page schedule by pid page.
     *
     * @param pageable the pageable，默认第一页，每页30条
     * @param pid      the pid
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:35:08
     */
    @GetMapping("/findPageScheduleByPid")
    public Page<Schedule> findPageScheduleByPid(@PageableDefault(size = 30) Pageable pageable, Long pid) {
        return scheduleService.findPageScheduleByPid(pageable, pid);
    }

    /**
     * Find page schedule by status page.
     *
     * @param pageable the pageable，默认第一页，每页30条
     * @param status   the status
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:35:50
     */
    @GetMapping("/findPageScheduleByStatus")
    public Page<Schedule> findPageScheduleByStatus(@PageableDefault(size = 30) Pageable pageable, Integer status) {
        return scheduleService.findPageScheduleByStatus(pageable, status);
    }

    /**
     * Find page schedule by update time page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:40:17
     */
    @PostMapping("/findPageScheduleByUpdateTime")
    public Page<Schedule> findPageScheduleByUpdateTime(@PageableDefault(size = 30) Pageable pageable, String startDate, String endDate) {
        return scheduleService.findPageScheduleByUpdateTime(pageable, startDate, endDate);
    }

    /**
     * Find schedule by id schedule.
     *
     * @param id the id
     * @return the schedule
     */
    @GetMapping("/findById")
    public Schedule findScheduleById(Long id) {
        return scheduleService.findScheduleById(id);
    }

    /**
     * End by id long.
     *
     * @param id the id
     * @return the long
     */
    @GetMapping("/endById")
    public Schedule deleteById(Long id) {
        return scheduleService.endScheduleById(id);
    }
}
