package cn.hwd.service;

import cn.hwd.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll();
}
