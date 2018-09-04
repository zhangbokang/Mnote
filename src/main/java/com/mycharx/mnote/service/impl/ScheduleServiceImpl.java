package com.mycharx.mnote.service.impl;

import com.mycharx.mnote.entity.Schedule;
import com.mycharx.mnote.repository.ScheduleRepository;
import com.mycharx.mnote.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * The type Schedule service.
 *
 * @author 张卜亢
 * @date 2018.09.04 18:10:53
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        schedule.setUpdateTime(System.currentTimeMillis());
        schedule.setStatus(1);
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        schedule.setUpdateTime(System.currentTimeMillis());
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        scheduleRepository.delete(schedule);
    }

    @Override
    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule findScheduleById(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            return optionalSchedule.get();
        }
        return new Schedule();
    }

    @Override
    public List<Schedule> findSecheduleLikeTitle(String title) {
        return null;
    }

    @Override
    public Page<Schedule> findPageSechedule(Pageable pageable) {
        return scheduleRepository.findSchedulesByPidNull(pageable);
    }

    @Override
    public Page<Schedule> findPageScheduleByPid(Pageable pageable, Long pid) {
        return scheduleRepository.findSchedulesByPid(pageable, pid);
    }

    @Override
    public Page<Schedule> findPageScheduleByStatus(Pageable pageable, Integer pid) {
        return scheduleRepository.findSchedulesByStatusAndPidNull(pageable, pid);
    }
}
