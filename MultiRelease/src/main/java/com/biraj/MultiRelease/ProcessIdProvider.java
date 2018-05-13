package com.biraj.MultiRelease;

import java.lang.management.ManagementFactory;

public class ProcessIdProvider {

	public ProcessIdDescriptor getPid() {
        String vmName = ManagementFactory.getRuntimeMXBean().getName();
        long pid = Long.parseLong( vmName.split( "@" )[0] );
        return new ProcessIdDescriptor( pid, "RuntimeMXBean" );
    }
}
