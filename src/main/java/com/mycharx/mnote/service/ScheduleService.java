package com.mycharx.mnote.service;

import com.mycharx.mnote.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Schedule service.
 *
 * @author 张卜亢
 * @date 2018.09.03 21:26:35
 */
public interface ScheduleService {
    /**
     * Save schedule schedule.
     *
     * @param schedule the schedule
     * @return the schedule
     */
    Schedule saveSchedule(Schedule schedule);

    /**
     * Update schedule schedule.
     *
     * @param schedule the schedule
     * @return the schedule
     */
    Schedule updateSchedule(Schedule schedule);

    /**
     * Delete schedule.
     *
     * @param schedule the schedule
     */
    void deleteSchedule(Schedule schedule);

    /**
     * Delete schedule by id.
     *
     * @param id the id
     */
    void deleteScheduleById(Long id);

    /**
     * Find schedule by id schedule.
     *
     * @param id the id
     * @return the schedule
     */
    Schedule findScheduleById(Long id);

    /**
     * Find sechedule like title list.
     *
     * @param title the title
     * @return the list
     */
    List<Schedule> findSecheduleLikeTitle(String title);

    /**
     * Find page sechedule page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Schedule> findPageSechedule(Pageable pageable);

    /**
     * Find page schedule by pid page.
     *
     * @param pageable the pageable
     * @param pid      the pid
     * @return the page
     */
    Page<Schedule> findPageScheduleByPid(Pageable pageable, Long pid);

    /**
     * Find page schedule by status page.
     *
     * @param pageable the pageable
     * @param pid      the pid
     * @return the page
     */
    Page<Schedule> findPageScheduleByStatus(Pageable pageable, Integer pid);
}
