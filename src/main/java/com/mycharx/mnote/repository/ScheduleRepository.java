package com.mycharx.mnote.repository;

import com.mycharx.mnote.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Schedule repository.
 *
 * @author 张卜亢
 * @date 2018.09.04 17:19:34
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    /**
     * 分页查询所有PID为null的节点，也就是顶级节点
     *
     * @param pageable the pageable
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:48:39
     */
    Page<Schedule> findSchedulesByPidNullOrderByStatusDescPriorityAscUpdateTimeDesc(Pageable pageable);

    /**
     * Find schedules by pid page.
     *
     * @param pageable the pageable
     * @param pid      the pid
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:48:40
     */
    Page<Schedule> findSchedulesByPid(Pageable pageable, Long pid);

    /**
     * Find schedules by status page.
     *
     * @param pageable the pageable
     * @param status   the status
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:48:40
     */
    Page<Schedule> findSchedulesByStatusAndPidNull(Pageable pageable, Integer status);

    /**
     * Find schedules by update time greater than and update time less than equal page.
     *
     * @param pageable        the pageable
     * @param startUpdateTime the start update time
     * @param endUpdateTime   the end update time
     * @return the page
     * @author 张卜亢
     * @date 2018.09.14 21:48:40
     */
    Page<Schedule> findSchedulesByPidIsNullAndUpdateTimeGreaterThanEqualAndUpdateTimeLessThanOrderByStatusDescPriorityAscUpdateTimeDesc(Pageable pageable, Long startUpdateTime, Long endUpdateTime);
}
