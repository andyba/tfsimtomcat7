package org.andy.pf.tfsim.simulator;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

/**
 *
 * @author a.bailey
 */
//@Singleton
//@Startup
public class AsynchDirectionChangeSimulator {

    final static String[] DIRS = {
        "North",
        "Northeast",
        "East",
        "Southeast",
        "South",
        "Southwest",
        "West",
        "Northwest"
    };
    
    
 //   @Schedule(minute = "*", second = "*/1", hour = "*")
    public void pushDirection() {
        String nextDirection = DIRS[(int)(Math.random()*DIRS.length)];
        PushContext ctx = PushContextFactory.getDefault().getPushContext();
        if( ctx != null ) {
            ctx.push("/tfSim", nextDirection);
        }
    }
}
