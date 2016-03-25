package org.beer30.silvia.sample.springintegration;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsweets on 3/25/16.
 */
public class JobExecutionsRouter {

    @Router
    public List<String> routeJobExecution(JobExecution jobExecution) {

        final List<String> routeToChannels = new ArrayList<String>();

        if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
            routeToChannels.add("jobRestarts");
        }
        else {

            if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
                routeToChannels.add("completeApplication");
            }

            routeToChannels.add("notifiableExecutions");
        }

        return routeToChannels;
    }
}
