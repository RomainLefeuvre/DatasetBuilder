package fr.inria.diverse.swhModel.generator

import java.util.UUID

class Helper {
	def static String generateVarName(){
		return "var_"+UUID.randomUUID.toString.replace("-","")
		
	}
}
