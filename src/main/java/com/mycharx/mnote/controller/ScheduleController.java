package com.mycharx.mnote.controller;

import com.mycharx.mnote.entity.Schedule;
import com.mycharx.mnote.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
     * @param page the page
     * @param size the size
     * @return the page
     */
    @GetMapping("/findPageSchedule")
    public Page<Schedule> findPageSchedule(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        return scheduleService.findPageSechedule(pageable);
    }

    /**
     * Find page schedule by pid page.
     *
     * @param page the page
     * @param size the size
     * @param pid  the pid
     * @return the page
     */
    @GetMapping("/findPageScheduleByPid")
    public Page<Schedule> findPageScheduleByPid(Integer page, Integer size, Long pid) {
        Pageable pageable = new PageRequest(page, size);
        return scheduleService.findPageScheduleByPid(pageable, pid);
    }

    /**
     * Find page schedule by status page.
     *
     * @param page   the page
     * @param size   the size
     * @param status the status
     * @return the page
     */
    @GetMapping("/findPageScheduleByStatus")
    public Page<Schedule> findPageScheduleByStatus(Integer page, Integer size, Integer status) {
        Pageable pageable = new PageRequest(page, size);
        return scheduleService.findPageScheduleByStatus(pageable, status);
    }

    /**
     * Find schedule by id schedule.
     *
     * @param id the id
     * @return the schedule
     */
    @GetMapping("/findById")
    public Schedule findScheduleById(Long id){
        return scheduleService.findScheduleById(id);
    }
}
