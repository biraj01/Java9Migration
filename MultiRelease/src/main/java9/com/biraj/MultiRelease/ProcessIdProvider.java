package com.biraj.MultiRelease;


public class ProcessIdProvider {

	 public ProcessIdDescriptor getPid() {
	        long pid = ProcessHandle.current().pid();
	        return new ProcessIdDescriptor( pid, "ProcessHandle" );
	    }
}
