package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.constant.Const;
import com.yygq.demo.dao.AssessorDao;
import com.yygq.demo.entity.Assessor;
import com.yygq.demo.service.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implement assessor service
 * @author ame
 */
@Service
public class AssessorServiceImpl implements AssessorService {

    private final AssessorDao assessorDao;

    @Autowired

    public AssessorServiceImpl(AssessorDao assessorDao){
        this.assessorDao = assessorDao;
    }

    @Override
    public Boolean insert(Assessor assessor){
        assessor.setStatus(1);
        String identityNumberDigest = null;
        String tmp = assessor.getPassword();
        String salt = IdUtil.simpleUUID();
        String pass = SecureUtil.sha256(tmp + Const.SALT_PREFIX + salt);
        assessor.setPassword(pass);
        assessor.setSalt(salt);

        if(StrUtil.isNotBlank(assessor.getIdentityNumber())){
            identityNumberDigest = SecureUtil.sha256(assessor.getIdentityNumber());
            assessor.setIdentityNumber(identityNumberDigest);
        }

        return assessorDao.insert(assessor) > 0;
    }

    @Override
    public Boolean delete(Long id){
        return assessorDao.delete(id) > 0;
    }

    @Override
    public Boolean update(Assessor assessor, Long id){
        Assessor exist = getAssessor(id);

        if(StrUtil.isNotBlank(assessor.getPassword())){
            String tmp = assessor.getPassword();
            String salt = IdUtil.simpleUUID();
            String pass = SecureUtil.sha256(tmp + Const.SALT_PREFIX + salt);
            assessor.setSalt(salt);
            assessor.setPassword(pass);
        }
        BeanUtil.copyProperties(assessor, exist, CopyOptions.create().setIgnoreNullValue(true));
        return assessorDao.update(assessor, id) > 0;
    }

    @Override
    public Assessor getAssessor(Long id){
        return assessorDao.selectById(id);
    }

    @Override
    public List<Assessor> getAssessors(Assessor assessor){
        return assessorDao.selectAssessorList(assessor);
    }

    @Override
    public List<Assessor> getAll(){
        return assessorDao.selectAllAssessor();
    }


}
