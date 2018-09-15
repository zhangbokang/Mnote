package com.mycharx.mnote.service.impl;

import com.mycharx.mnote.entity.Schedule;
import com.mycharx.mnote.repository.ScheduleRepository;
import com.mycharx.mnote.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

/**
 * The type Schedule service.
 *
 * @author 张卜亢
 * @date 2018.09.04 18:10:53
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ScheduleServiceImpl implements ScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    @Resource
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule saveOrUpdateSchedule(Schedule schedule) {
        schedule.setUpdateTime(System.currentTimeMillis());
        Schedule s;
        if (schedule.getId() != null) {
            s = findScheduleById(schedule.getId());
            BeanUtils.copyProperties(schedule, s, "id", "chilSchedules");
        } else {
            s = schedule;
        }
        if (s.getPid() != null) {
            Schedule ps = findScheduleById(s.getPid());
            ps.setUpdateTime(System.currentTimeMillis());
            scheduleRepository.save(ps);
        }
        return scheduleRepository.save(s);
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        scheduleRepository.delete(schedule);
    }

    @Override
    public Schedule endScheduleById(Long id) {
        Schedule s = findScheduleById(id);
        s.setStatus(-1);
        s.setUpdateTime(System.currentTimeMillis());
        return saveOrUpdateSchedule(s);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public Schedule findScheduleById(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            return optionalSchedule.get();
        }
        return new Schedule();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public List<Schedule> findSecheduleLikeTitle(String title) {
        return null;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public Page<Schedule> findPageSechedule(Pageable pageable) {
        return scheduleRepository.findSchedulesByPidNullOrderByStatusDescPriorityAscUpdateTimeDesc(pageable);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public Page<Schedule> findPageScheduleByPid(Pageable pageable, Long pid) {
        return scheduleRepository.findSchedulesByPid(pageable, pid);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = RuntimeException.class)
    public Page<Schedule> findPageScheduleByStatus(Pageable pageable, Integer pid) {
        return scheduleRepository.findSchedulesByStatusAndPidNull(pageable, pid);
    }

    @Override
    public Page<Schedule> findPageScheduleByUpdateTime(Pageable pageable, String startDate, String endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Long startUpdateTime = simpleDateFormat.parse(startDate).getTime();
            Long endUpdateTime = simpleDateFormat.parse(endDate).getTime() + 86400000;
            return scheduleRepository.findSchedulesByPidIsNullAndUpdateTimeGreaterThanEqualAndUpdateTimeLessThanOrderByStatusDescPriorityAscUpdateTimeDesc(pageable, startUpdateTime, endUpdateTime);
        } catch (Exception e) {
            logger.warn("根据日期范围查询失败", e);
            throw new RuntimeException("根据范围查询失败");
        }
    }
}
