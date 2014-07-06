/**
 * 
 */
package cn.newcapec.function.ecardcity.om.biz.impl;

import java.util.Map;

import org.apache.commons.chain.web.WebContext;
import org.apache.struts.chain.contexts.WebActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newcapec.framework.core.utils.pagesUtils.Page;
import cn.newcapec.function.ecardcity.om.biz.StudentService;
import cn.newcapec.function.ecardcity.om.dao.StudentDao;
import cn.newcapec.function.ecardcity.om.model.Student;

/**
 * 学生业务接口实现类
 * @author Administrator
 *
 */
@Service("studentService")
@Transactional
@SuppressWarnings("all")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void removeUnused(String id) {
		studentDao.delete(id);
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public Student get(String id) {
		return studentDao.get(id);
	}

	@Override
	public void saveOrUpdate(Student paramT) {
		studentDao.saveOrUpdate(paramT);
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public Page querys(Map<String, Object> paramMap) {
		Page page=studentDao.querys(paramMap);
		return page;
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public Student findById(String id) {
		return studentDao.get(id);
	}

	@Override
	public void delete(String[] ids) {
		 studentDao.delete(ids);
	}

}
