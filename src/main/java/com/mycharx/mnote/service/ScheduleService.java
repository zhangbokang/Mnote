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
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Schedule saveOrUpdateSchedule(Schedule schedule);

    /**
     * Delete schedule.
     *
     * @param schedule the schedule
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    void deleteSchedule(Schedule schedule);

    /**
     * End schedule by id.
     *
     * @param id the id
     * @return the schedule
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Schedule endScheduleById(Long id);

    /**
     * Find schedule by id schedule.
     *
     * @param id the id
     * @return the schedule
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Schedule findScheduleById(Long id);

    /**
     * Find sechedule like title list.
     *
     * @param title the title
     * @return the list
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    List<Schedule> findSecheduleLikeTitle(String title);

    /**
     * Find page sechedule page.
     *
     * @param pageable the pageable
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Page<Schedule> findPageSechedule(Pageable pageable);

    /**
     * Find page schedule by pid page.
     *
     * @param pageable the pageable
     * @param pid      the pid
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Page<Schedule> findPageScheduleByPid(Pageable pageable, Long pid);

    /**
     * Find page schedule by status page.
     *
     * @param pageable the pageable
     * @param pid      the pid
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Page<Schedule> findPageScheduleByStatus(Pageable pageable, Integer pid);

    /**
     * Find page schedule by update time page.
     *
     * @param pageable  the pageable
     * @param startTime the start time
     * @param endTime   the end time
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:39:43
     */
    Page<Schedule> findPageScheduleByUpdateTime(Pageable pageable, String startTime, String endTime);
}
