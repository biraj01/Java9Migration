package com.biraj.MultiRelease;

public class ProcessIdDescriptor {
	private  long pid;
	
    private  String providerName;
    
	public ProcessIdDescriptor(long pid, String providerName) {
		this.pid = pid;
		this.providerName = providerName;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
		
	
	
}
