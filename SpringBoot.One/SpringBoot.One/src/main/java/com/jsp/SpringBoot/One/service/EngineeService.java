package com.jsp.SpringBoot.One.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.SpringBoot.One.dao.CarDao;
import com.jsp.SpringBoot.One.dao.EngineeDao;
import com.jsp.SpringBoot.One.entity.Car;
import com.jsp.SpringBoot.One.entity.Enginee;
import com.jsp.SpringBoot.One.utill.ResponceStructure;

@Service
public class EngineeService {
	@Autowired
	private EngineeDao engneDao;
	@Autowired
	private CarDao cardao;

	public ResponseEntity<ResponceStructure<Enginee>> saveEnginee(int id, Enginee e) {
		Car c = cardao.getCarById(id);
		Enginee engine = null;
		if (c != null) {
			c.setEnginee(e);
			engine=engneDao.saveEngine(e);
			cardao.saveCar(c);
			ResponceStructure<Enginee> rs = new ResponceStructure<Enginee>();
			rs.setCode(HttpStatus.CREATED.value());
			rs.setData(e);
			rs.setMessage("Engnigee details Saved");
			engneDao.saveEngine(engine);
			return new ResponseEntity<ResponceStructure<Enginee>>(rs, HttpStatus.CREATED);
		}else {
			Enginee e1 =new Enginee();
			c.setEnginee(e1);
			engine=engneDao.saveEngine(e1);
			cardao.saveCar(c);
			ResponceStructure<Enginee> rs = new ResponceStructure<Enginee>();
			engneDao.saveEngine(engine);
			return new ResponseEntity<ResponceStructure<Enginee>>(rs, HttpStatus.BAD_REQUEST);			
		}
	}

	public ResponseEntity<ResponceStructure<Enginee>> getByEngineId(int id) {
		ResponceStructure<Enginee> rs = new ResponceStructure<Enginee>();
		rs.setCode(HttpStatus.OK.value());
		rs.setData(engneDao.getByEngineId(id));
		rs.setMessage("Engnigee detail of " + id);
		return new ResponseEntity<ResponceStructure<Enginee>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponceStructure<Enginee>> deleteEngniee(int id) {
		ResponceStructure<Enginee> rs = new ResponceStructure<Enginee>();
		rs.setCode(HttpStatus.OK.value());
		rs.setMessage("Enginee details of " + id + " Deleted");
		engneDao.deleteEngnie(id);
		return new ResponseEntity<ResponceStructure<Enginee>>(rs, HttpStatus.OK);
	}
}
