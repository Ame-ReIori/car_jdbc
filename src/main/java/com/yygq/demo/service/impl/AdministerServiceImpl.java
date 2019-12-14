package com.yygq.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.yygq.demo.constant.Const;
import com.yygq.demo.dao.AdministerDao;
import com.yygq.demo.entity.Administer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministerServiceImpl {

    private final AdministerDao administerDao;

    @Autowired
    public AdministerServiceImpl(AdministerDao administerDao){
        this.administerDao = administerDao;
    }

    public Boolean insert(Administer administer){
        String tmp = administer.getPassword();
        String salt = IdUtil.simpleUUID();
        String pass = SecureUtil.sha256(tmp + Const.SALT_PREFIX + salt);
        administer.setPassword(pass);
        administer.setSalt(salt);

        String identityNumberDigest = SecureUtil.sha256(administer.getIdentityNumber());
        administer.setIdentityNumber(identityNumberDigest);

        String adminName = administer.getName();
        String phoneNumber = administer.getPhone();
        String mac = SecureUtil.sha256(adminName + pass + salt + phoneNumber + identityNumberDigest);
        administer.setMac(mac);
        return administerDao.insert(administer) > 0;
    }

    public Boolean delete(Long id){
        return administerDao.delete(id) > 0;
    }

    public Boolean update(Administer administer, Long id){
        Administer exist = getAdmin(id);
        String tmp = null;
        String salt = exist.getSalt();
        String pass = exist.getPassword();
        String identityNumberDigest = exist.getIdentityNumber();
        String mac = null;

        if(StrUtil.isNotBlank(administer.getPassword())){
            tmp = administer.getPassword();
            salt = IdUtil.simpleUUID();
            pass = SecureUtil.sha256(tmp + Const.SALT_PREFIX + salt);
            administer.setSalt(salt);
            administer.setPassword(pass);
        }

        if(StrUtil.isNotBlank(administer.getIdentityNumber())){
            identityNumberDigest = SecureUtil.sha256(administer.getIdentityNumber());
            administer.setIdentityNumber(identityNumberDigest);
        }

        mac = SecureUtil.sha256(exist.getAdminId() + pass + salt + exist.getPhone() + identityNumberDigest);
        administer.setMac(mac);
        BeanUtil.copyProperties(administer, exist, CopyOptions.create().setIgnoreNullValue(true));
        exist.setLastUpdateTime(new DateTime());
        return administerDao.update(administer, id) > 0;
    }

    public Administer getAdmin(Long id){
        return administerDao.selectById(id);
    }

    public List<Administer> getAdmins(Administer administer){
        return administerDao.selectAdministerList(administer);
    }

    public List<Administer> getAll(){
        return administerDao.selectAll();
    }
}
