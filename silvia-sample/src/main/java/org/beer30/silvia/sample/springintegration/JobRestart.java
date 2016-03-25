package org.beer30.silvia.sample.springintegration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by tsweets on 3/25/16.
 */
public class JobRestart {



    private static final Log logger = LogFactory.getLog(JobRestart.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @ServiceActivator
    public void restartIfPossible(JobExecution execution) throws JobInstanceAlreadyCompleteException, JobParametersInvalidException, JobRestartException, JobExecutionAlreadyRunningException {
        logger.info("Restarting job...");
        jobLauncher.run(job, execution.getJobParameters());
    }
}
