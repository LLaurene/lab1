package com.Risk.domain;

public class Mission {
	private int M_Id;
	private String M_Condition;
	
	public Mission() {}
	public Mission(String uneCondition){
		setM_Condition(uneCondition);
	}
	
	
	
	
	
	private int getM_Id() {
		return M_Id;
	}
	private void setM_Id(int m_Id) {
		M_Id = m_Id;
	}
	private String getM_Condition() {
		return M_Condition;
	}
	private void setM_Condition(String m_Condition) {
		M_Condition = m_Condition;
	}
}

