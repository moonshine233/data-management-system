package cn.hwd.service.impl;

import cn.hwd.dao.SysLogDao;
import cn.hwd.domain.SysLog;
import cn.hwd.service.SysLogService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {

        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {

        return sysLogDao.findAll();
    }
}
