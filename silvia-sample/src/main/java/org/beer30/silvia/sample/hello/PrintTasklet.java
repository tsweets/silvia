package org.beer30.silvia.sample.hello;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Created by tsweets on 3/25/16.
 */
public class PrintTasklet implements Tasklet {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.print(message);
        return RepeatStatus.FINISHED;

    }
}
