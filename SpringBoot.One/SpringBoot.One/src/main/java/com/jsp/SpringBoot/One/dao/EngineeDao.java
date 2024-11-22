package com.jsp.SpringBoot.One.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBoot.One.entity.Enginee;
import com.jsp.SpringBoot.One.reposiory.EngineeRepsitory;

@Repository
public class EngineeDao {

	@Autowired
	private EngineeRepsitory engnerepo;
	
	public Enginee saveEngine(Enginee engniee) {
		return engnerepo.save(engniee);
	}

	public Enginee getByEngineId(int id ) {
		Optional<Enginee> op = engnerepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
		
		public boolean deleteEngnie(int id) {
			if (getByEngineId(id) != null) {
				engnerepo.delete(getByEngineId(id));
				return true;
			}
			return false;
	}
}
