package com.app.exception;

public class VehicleOperationExceptionn   extends RuntimeException 

{
	public VehicleOperationExceptionn (String message)
	{
		super(message);
	}
	
	public VehicleOperationExceptionn(
            String message, Throwable cause) {
        super(message, cause);
    }


}
