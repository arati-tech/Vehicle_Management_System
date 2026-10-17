package com.app.servicei;

import com.app.model.Vehicle;

public interface Requirements 
{
	void insertData(Vehicle v);
	void getSingleData(int id);
	void getAllData();
	void updateData(int id,String name,String number ,String type, Double price);
	void deleteData(int id);
	void deleteAllData();	

}
